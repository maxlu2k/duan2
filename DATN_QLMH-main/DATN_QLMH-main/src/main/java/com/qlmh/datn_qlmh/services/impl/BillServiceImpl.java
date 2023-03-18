package com.qlmh.datn_qlmh.services.impl;

import com.qlmh.datn_qlmh.dtos.request.BillRequest;
import com.qlmh.datn_qlmh.entities.BillEntity;
import com.qlmh.datn_qlmh.entities.DetailBillEntity;
import com.qlmh.datn_qlmh.entities.ProductEntity;
import com.qlmh.datn_qlmh.exceptions.BadRequestException;
import com.qlmh.datn_qlmh.exceptions.NotFoundException;
import com.qlmh.datn_qlmh.repositories.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BillServiceImpl {
    private final AccountRepo accountRepo;
    private final ProductRepo productRepo;
    private final BillRepo billRepo;
    private final DetailBillRepo detailBillRepo;
    private final VoucherRepo voucherRepo;
    private final DiscountRepo discountRepo;
    private final VoucherAccountRepo voucherAccountRepo;
    private final ProductDiscountRepo productDiscountRepo;

    public BillServiceImpl(AccountRepo accountRepo, ProductRepo productRepo, BillRepo billRepo,
                           DetailBillRepo detailBillRepo, VoucherRepo voucherRepo, DiscountRepo discountRepo,
                           VoucherAccountRepo voucherAccountRepo, ProductDiscountRepo productDiscountRepo) {
        this.accountRepo = accountRepo;
        this.productRepo = productRepo;
        this.billRepo = billRepo;
        this.detailBillRepo = detailBillRepo;
        this.voucherRepo = voucherRepo;
        this.discountRepo = discountRepo;
        this.voucherAccountRepo = voucherAccountRepo;
        this.productDiscountRepo = productDiscountRepo;
    }
    public BillRequest saveOrder(BillRequest billRequest) {
        if (accountRepo.findById(billRequest.getUsername()).isEmpty()) {
            throw new NotFoundException("User not exist");
        }
        billRequest.getDetailBillRequests().forEach(orderDetailRq -> {
            ProductEntity productEntity = Optional.ofNullable(this.productRepo.findByIdAndStatus(orderDetailRq.getProductId(), 1))
                    .orElseThrow(()-> new NotFoundException("CartDetail Not Found"));

            if(productEntity.getQuantity() < orderDetailRq.getAmount()){
                throw new BadRequestException("Số lượng sản phẩm không đủ");
            }
        });

        List<DetailBillEntity> orderDetailEntityList = new ArrayList<>();

        if (billRequest.getDetailBillRequests().size() != 0) {

            BillEntity billProductAvailable = new BillEntity();
            BillEntity billProductPre = new BillEntity();

            for (BillRequest.DetailBillRequest detailBillRq : billRequest.getDetailBillRequests()) {

                ProductEntity productEntity = Optional.ofNullable(this.productRepo.findByIdAndStatus(detailBillRq.getProductId(), 1))
                        .orElseThrow(()-> new NotFoundException("Product Not Found"));

                if(productEntity.getQuantity() < detailBillRq.getAmount()){
                    throw new BadRequestException("Số lượng sản phẩm không đủ");
                }
                DetailBillEntity detailBill = new DetailBillEntity();

                if (detailBillRq.getTypeOfBill() == 0) {
                    Double deposit = Double.valueOf(detailBillRq.getPriceSale().doubleValue() / 50)* 100;

                    BeanUtils.copyProperties(billRequest, billProductAvailable);
                    billProductAvailable.setTypeOfBill(0);
                    billProductAvailable.setTotalDeposit(BigDecimal.valueOf(deposit));

                    billProductAvailable = this.billRepo.save(billProductAvailable);

                    BeanUtils.copyProperties(detailBillRq, detailBill);
                    detailBill.setBillId(billProductAvailable.getId());
                    detailBill.setTypeOfBill(0);

                    orderDetailEntityList.add(detailBill);
                }
                if (detailBillRq.getTypeOfBill() == 1) {

                    BeanUtils.copyProperties(billRequest, billProductPre);
                    billProductPre.setTypeOfBill(1);

                    billProductPre = this.billRepo.save(billProductPre);

                    BeanUtils.copyProperties(detailBillRq, detailBill);
                    detailBill.setBillId(billProductPre.getId());
                    detailBill.setTypeOfBill(1);
                    orderDetailEntityList.add(detailBill);
                }
                detailBillRepo.saveAll(orderDetailEntityList);
            }
        }
        return billRequest;
    }

}
