package com.qlmh.datn_qlmh.services.impl;

import com.qlmh.datn_qlmh.dtos.request.RateImgReq;
import com.qlmh.datn_qlmh.dtos.request.RateReq;
import com.qlmh.datn_qlmh.entities.RateImgEntity;
import com.qlmh.datn_qlmh.entities.VoucherEntity;
import com.qlmh.datn_qlmh.exceptions.InvalidArgumentException;
import com.qlmh.datn_qlmh.exceptions.NotFoundException;
import com.qlmh.datn_qlmh.repositories.RateImgRepo;
import com.qlmh.datn_qlmh.services.RateImgService;
import com.qlmh.datn_qlmh.services.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RateImgServiceImpl implements RateImgService {
    @Autowired
    RateImgRepo rateImgRepo;

    @Autowired
    Mapper mapper;

    @Override
    public RateImgReq getById(Integer imgID) {
        RateImgEntity rateImgEntity = rateImgRepo.findById(imgID).orElseThrow(() -> new NotFoundException("rate img not found : " + imgID));

        return mapper.toRateImgReq(rateImgEntity);
    }

    @Override
    public RateImgReq create(RateImgReq rateImgReq) {
        RateImgEntity rateImgEntity = mapper.toRateImgEntity(rateImgReq);
        rateImgRepo.save(rateImgEntity);
        return mapper.toRateImgReq(rateImgEntity);
    }

    @Override
    public RateImgReq update(RateImgReq rateImgReq) {
        if (rateImgReq.getId() == null) throw new InvalidArgumentException("id is not null ");
        RateImgEntity rateImgEntity = rateImgRepo.findById(rateImgReq.getId()).orElseThrow(() -> new NotFoundException("Rateimg not found : " + rateImgReq.getId()));
        rateImgEntity = mapper.toRateImgEntity(rateImgReq);
        rateImgRepo.save(rateImgEntity);
        return mapper.toRateImgReq(rateImgEntity);
    }

    @Override
    public List<RateImgReq> getByRateID(Integer rateID) {
        System.out.println("12345");
        System.out.println("abcr"+rateImgRepo.findByRate(rateID));
        return rateImgRepo.findByRate(rateID).stream().map((entity)->mapper.toRateImgReq(entity)).collect(Collectors.toList());

    }
}
