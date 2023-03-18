package com.qlmh.datn_qlmh.services;

import com.qlmh.datn_qlmh.dtos.request.DiscountReq;

import java.util.List;

public interface DiscountService {
    DiscountReq save(DiscountReq voucherReq);
    DiscountReq update(DiscountReq voucherReq);
    void delete(Long id);

    List<DiscountReq> findAll();
    DiscountReq findById(Long id);

}
