package com.qlmh.datn_qlmh.services;

import com.qlmh.datn_qlmh.dtos.request.RateImgReq;
import com.qlmh.datn_qlmh.dtos.request.RateReq;
import com.qlmh.datn_qlmh.entities.RateImgEntity;

import java.util.List;

public interface RateImgService {
    public RateImgReq getById(Integer imgID);
    public RateImgReq create(RateImgReq rateImgReq);
    public RateImgReq update(RateImgReq rateImgReq);
    public List<RateImgReq> getByRateID(Integer rateID);
}
