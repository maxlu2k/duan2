package com.qlmh.datn_qlmh.dtos.Items;

import com.qlmh.datn_qlmh.dtos.request.DiscountReq;
import com.qlmh.datn_qlmh.dtos.request.VoucherReq;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class DetailCartItems {
    private Integer id;
    private Integer productId;
    private BigDecimal price;
    private List<VoucherReq> voucherReqs;
    private DiscountReq discountReq;
    private int amount;
    private List<ImgProductItems> productImg;
    private String productName;
    private String url;

}
