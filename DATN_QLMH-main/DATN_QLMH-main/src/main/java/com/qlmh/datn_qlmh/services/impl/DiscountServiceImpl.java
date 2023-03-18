package com.qlmh.datn_qlmh.services.impl;

import com.qlmh.datn_qlmh.dtos.request.DiscountReq;
import com.qlmh.datn_qlmh.entities.DiscountEntity;
import com.qlmh.datn_qlmh.exceptions.InvalidArgumentException;
import com.qlmh.datn_qlmh.exceptions.NotFoundException;
import com.qlmh.datn_qlmh.repositories.DiscountRepo;
import com.qlmh.datn_qlmh.services.DiscountService;
import com.qlmh.datn_qlmh.services.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepo discountRepo;
    private final Mapper mapper;

    @Autowired
    public DiscountServiceImpl(DiscountRepo discountRepo, Mapper map) {
        this.discountRepo =discountRepo;
        mapper = map;
    }

    @Override
    public DiscountReq save(DiscountReq discountReq) {
        DiscountEntity discountEntity = mapper.toDiscountEntity(discountReq);
        discountEntity =discountRepo.save(discountEntity);
        return mapper.toDiscountReq(discountEntity);
    }

    @Override
    public void delete(Long id) {

        DiscountEntity discountEntity =discountRepo.findById(id).orElseThrow(()->new NotFoundException("Discount not found : "+id));
        discountEntity.setStatus(false);
        discountRepo.save(discountEntity);
    }

    @Override
    public DiscountReq update(DiscountReq discountReq) {
        if(discountReq.getId() == null) throw new InvalidArgumentException("id is not null ");

        DiscountEntity discountEntity =discountRepo.findById(discountReq.getId()).orElseThrow(()->new NotFoundException("Discount not found : "+discountReq.getId()));
        discountEntity = mapper.toDiscountEntity(discountReq);
        discountEntity = discountRepo.save(discountEntity);
        return mapper.toDiscountReq(discountEntity);
    }

    @Override
    public List<DiscountReq> findAll() {
        return discountRepo.findAll().stream().map((entity)->mapper.toDiscountReq(entity)).collect(Collectors.toList());
    }

    @Override
    public DiscountReq findById(Long id) {

        DiscountEntity discountEntity =discountRepo.findById(id).orElseThrow(()->new NotFoundException("Discount not found : "+id));
//        blackListService.getBlackListByDiscountId(discountEntity.getId());
        return mapper.toDiscountReq(discountEntity);
    }
}
