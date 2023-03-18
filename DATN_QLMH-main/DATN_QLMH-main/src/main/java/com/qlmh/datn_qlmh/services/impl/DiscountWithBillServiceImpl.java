package com.qlmh.datn_qlmh.services.impl;

import com.qlmh.datn_qlmh.common.PageData;
import com.qlmh.datn_qlmh.dtos.request.DiscountWithBillReq;
import com.qlmh.datn_qlmh.entities.DiscountWithBillEntity;
import com.qlmh.datn_qlmh.exceptions.InvalidArgumentException;
import com.qlmh.datn_qlmh.exceptions.NotFoundException;
import com.qlmh.datn_qlmh.repositories.DiscountWithBillRepo;
import com.qlmh.datn_qlmh.services.DiscountWithBillService;
import com.qlmh.datn_qlmh.services.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountWithBillServiceImpl implements DiscountWithBillService {
    private final DiscountWithBillRepo discountWithBillRepo;
    private final Mapper mapper;


    @Autowired
    public DiscountWithBillServiceImpl(DiscountWithBillRepo discountWithBillRepo, Mapper map) {
        this.discountWithBillRepo = discountWithBillRepo;
        mapper = map;
    }

    @Override
    public DiscountWithBillReq save(DiscountWithBillReq voucherReq) {
        DiscountWithBillEntity discountWithBillEntity = mapper.toDiscountWithBillEntity(voucherReq);
        discountWithBillEntity = discountWithBillRepo.save(discountWithBillEntity);
        return mapper.toDiscountWithBillReq(discountWithBillEntity);
    }

    @Override
    public void delete(Long id) {

        DiscountWithBillEntity discountWithBillEntity = discountWithBillRepo.findById(id).orElseThrow(()->new NotFoundException("Discount not found : "+id));
        discountWithBillEntity.setStatus(false);
        discountWithBillRepo.save(discountWithBillEntity);
    }

    @Override
    public DiscountWithBillReq update(DiscountWithBillReq discountWithBillReq) {
        if(discountWithBillReq.getId() == null) throw new InvalidArgumentException("id is not null ");

        DiscountWithBillEntity discountWithBillEntity = discountWithBillRepo.findById(discountWithBillReq.getId()).orElseThrow(()->new NotFoundException("Discount not found : "+discountWithBillReq.getId()));
        discountWithBillEntity = mapper.toDiscountWithBillEntity(discountWithBillReq);
        discountWithBillEntity =  discountWithBillRepo.save(discountWithBillEntity);
        return mapper.toDiscountWithBillReq(discountWithBillEntity);
    }

    @Override
    public PageData<DiscountWithBillReq> findAll(Pageable pageable) {
        return new PageData<DiscountWithBillReq>(discountWithBillRepo.findAll(pageable));
    }

    @Override
    public DiscountWithBillReq findById(Long id) {

        DiscountWithBillEntity discountWithBillEntity = discountWithBillRepo.findById(id).orElseThrow(()->new NotFoundException("Discount not found : "+id));
        return mapper.toDiscountWithBillReq(discountWithBillEntity);
    }
}
