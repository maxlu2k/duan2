package com.qlmh.datn_qlmh.services;

import com.qlmh.datn_qlmh.common.PageData;
import com.qlmh.datn_qlmh.dtos.request.DiscountWithBillReq;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DiscountWithBillService {
    DiscountWithBillReq save(DiscountWithBillReq voucherReq);
    DiscountWithBillReq update(DiscountWithBillReq voucherReq);
    void delete(Long id);

    PageData<DiscountWithBillReq> findAll(Pageable pageable);
    DiscountWithBillReq findById(Long id);

}
