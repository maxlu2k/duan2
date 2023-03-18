package com.qlmh.datn_qlmh.services;

import com.qlmh.datn_qlmh.dtos.request.ImageReq;
import com.qlmh.datn_qlmh.dtos.response.ImageResp;

import java.util.List;

public interface ImageService {
    List<ImageResp> getAll();
    ImageReq create(ImageReq imageReq);
    ImageReq update(ImageReq imageReq);
    ImageReq getById(Integer id);
    List<ImageReq> getImageByProductID(Integer productID);
}
