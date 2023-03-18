package com.qlmh.datn_qlmh.dtos.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VoucherAccountDto {
    private VoucherReq voucherReq;
    private List<VoucherAccountReq> voucherAccountReq;
}
