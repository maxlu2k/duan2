package com.qlmh.datn_qlmh.services;

import com.qlmh.datn_qlmh.dtos.request.VoucherAccountDto;
import com.qlmh.datn_qlmh.dtos.request.VoucherAccountReq;
import com.qlmh.datn_qlmh.entities.AccountEntity;

import java.util.List;

public interface VoucherAccountService {
    public VoucherAccountReq add(VoucherAccountReq voucherAccountReq);

    public VoucherAccountDto getAllById(Long id);
    public VoucherAccountReq disable(VoucherAccountReq id);
    public void useVoucher(VoucherAccountReq voucherAccountReq);
    public AccountEntity accountEntity(String s);

}
