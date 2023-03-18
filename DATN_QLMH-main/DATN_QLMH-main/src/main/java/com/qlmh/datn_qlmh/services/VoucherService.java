package com.qlmh.datn_qlmh.services;

import com.qlmh.datn_qlmh.dtos.request.VoucherReq;

import java.util.List;

public interface VoucherService {
    VoucherReq save(VoucherReq voucherReq);
    VoucherReq update(VoucherReq voucherReq);
    void delete(Long id);

    List<VoucherReq> findAll();
    VoucherReq findById(Long id);

}
