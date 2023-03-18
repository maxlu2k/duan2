package com.qlmh.datn_qlmh.services.impl;

import com.qlmh.datn_qlmh.dtos.request.RateReq;
import com.qlmh.datn_qlmh.dtos.response.RateRes;
import com.qlmh.datn_qlmh.entities.RateEntity;
import com.qlmh.datn_qlmh.entities.RateImgEntity;
import com.qlmh.datn_qlmh.exceptions.InvalidArgumentException;
import com.qlmh.datn_qlmh.exceptions.NotFoundException;
import com.qlmh.datn_qlmh.repositories.RateImgRepo;
import com.qlmh.datn_qlmh.repositories.RateRepo;
import com.qlmh.datn_qlmh.services.RateService;
import com.qlmh.datn_qlmh.services.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RateServiceImpl implements RateService {
    @Autowired
    RateRepo rateRepo;

    @Autowired
    RateImgRepo rateImgRepo;

    @Autowired
    Mapper mapper;

    @Override
    public RateRes create(RateReq rateReq) {
        RateEntity rate = mapper.toRateEntity(rateReq);
        rate = rateRepo.save(rate);
        return mapper.toRateRes(rate);
    }

    @Override
    public RateRes getByID(Integer id) {
       RateEntity rateEntity =  rateRepo.findById(id).orElseThrow(() -> new NotFoundException("Rate not found : " + id));
        System.out.println(id);
       List<RateImgEntity> rateImgEntities = rateImgRepo.findByRate(id);
       RateRes rateRes =  mapper.toRateRes(rateEntity);
       rateRes.setImgs(rateImgEntities);
        return rateRes;
    }

    @Override
    public RateRes update(RateReq rateReq) {
        if (rateReq.getId() == null) {
            throw new InvalidArgumentException("id is not null ");
        }
        RateEntity rateEntity = rateRepo.findById(rateReq.getId()).orElseThrow(() -> new NotFoundException("rate not found : " + rateReq.getId()));
        rateEntity = mapper.toRateEntity(rateReq);
        rateEntity = rateRepo.save(rateEntity);
        return mapper.toRateRes(rateEntity);
    }

    @Override
    public List<RateRes> getAll() {
        return rateRepo.findAll().stream().map((entity) -> mapper.toRateRes(entity)).collect(Collectors.toList());
    }

    @Override
    public List<RateRes> getByProductID(Integer productID) {
        List<RateEntity> list = rateRepo.findByProductID(productID);
        List<RateRes> res = new ArrayList<RateRes>();

        for (RateEntity rateEntity : list) {
            List<RateImgEntity> rateImgEntities = rateImgRepo.findByRate(rateEntity.getId());
            RateRes rateRes =mapper.toRateRes(rateEntity);
            rateRes.setImgs(rateImgEntities);
            res.add(rateRes);


        }
        return res;
    }

    @Override
    public List<RateRes> getbyStart(Integer start) {
        return null;
    }
}
