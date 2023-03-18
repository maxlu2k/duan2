package com.qlmh.datn_qlmh.services.impl;

import com.qlmh.datn_qlmh.dtos.request.VoucherReq;
import com.qlmh.datn_qlmh.entities.VoucherEntity;
import com.qlmh.datn_qlmh.exceptions.InvalidArgumentException;
import com.qlmh.datn_qlmh.exceptions.NotFoundException;
import com.qlmh.datn_qlmh.repositories.VoucherRepo;
import com.qlmh.datn_qlmh.services.VoucherService;
import com.qlmh.datn_qlmh.services.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoucherServiceImpl implements VoucherService {
    private final VoucherRepo voucherRepo;
    private final Mapper voucherMapper;


    @Autowired
    public VoucherServiceImpl(VoucherRepo voucherRepo, Mapper voucherMapper) {
        this.voucherRepo = voucherRepo;
        this.voucherMapper = voucherMapper;
    }

    @Override
    public VoucherReq save(VoucherReq voucherReq) {
        VoucherEntity voucherEntity = voucherMapper.toVoucherEntity(voucherReq);
        System.out.println(voucherEntity);
        System.out.println(voucherEntity.getDiscountAmount() +" - "+ voucherEntity.getDiscountStart() +"");
        voucherEntity = voucherRepo.save(voucherEntity);
        System.out.println(voucherEntity);
        return voucherMapper.toVoucherReq(voucherEntity);
    }

    @Override
    public void delete(Long id) {

        VoucherEntity voucherEntity = voucherRepo.findById(id).orElseThrow(()->new NotFoundException("Voucher not found : "+id));
        voucherEntity.setStatus(false);
        voucherRepo.save(voucherEntity);
    }
    @Override
    public VoucherReq update(VoucherReq voucherReq) {
        if(voucherReq.getId() == null) throw new InvalidArgumentException("id is not null ");

        VoucherEntity voucherEntity = voucherRepo.findById(voucherReq.getId()).orElseThrow(()->new NotFoundException("Voucher not found : "+voucherReq.getId()));
        voucherEntity = voucherMapper.toVoucherEntity(voucherReq);
        voucherEntity =  voucherRepo.save(voucherEntity);
        return voucherMapper.toVoucherReq(voucherEntity);
    }

    @Override
    public List<VoucherReq> findAll() {
        return voucherRepo.findAll().stream().map((entity)->voucherMapper.toVoucherReq(entity)).collect(Collectors.toList());
    }

    @Override
    public VoucherReq findById(Long id) {

        VoucherEntity voucherEntity = voucherRepo.findById(id).orElseThrow(()->new NotFoundException("Voucher not found : "+id));
        return voucherMapper.toVoucherReq(voucherEntity);
    }
}
