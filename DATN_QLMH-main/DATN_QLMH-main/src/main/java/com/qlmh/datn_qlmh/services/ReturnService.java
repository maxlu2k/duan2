package com.qlmh.datn_qlmh.services;

import com.qlmh.datn_qlmh.dtos.request.ReturnReq;
import com.qlmh.datn_qlmh.entities.ReturnFigureEntity;

import java.util.List;

public interface ReturnService {

    ReturnReq create (ReturnReq returnReq);
    ReturnReq update(ReturnReq returnReq);
    List<ReturnReq> getAll();
    ReturnReq getById(Integer id);
}
