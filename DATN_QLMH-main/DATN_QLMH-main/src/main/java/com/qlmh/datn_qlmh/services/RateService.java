package com.qlmh.datn_qlmh.services;

import com.qlmh.datn_qlmh.dtos.request.RateImgReq;
import com.qlmh.datn_qlmh.dtos.request.RateReq;
import com.qlmh.datn_qlmh.dtos.response.RateRes;
import com.qlmh.datn_qlmh.entities.RateEntity;

import java.util.List;
import java.util.Optional;

public interface RateService {
  public  RateRes create(RateReq rateReq);

  public RateRes getByID(Integer id);
  public RateRes update(RateReq rateReq);
  public List<RateRes> getAll();
  public List<RateRes> getByProductID(Integer productID);

  public List<RateRes> getbyStart(Integer start);


}
