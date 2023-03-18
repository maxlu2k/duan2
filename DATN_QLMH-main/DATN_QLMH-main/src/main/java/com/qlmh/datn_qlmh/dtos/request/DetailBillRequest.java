package com.qlmh.datn_qlmh.dtos.request;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public class DetailBillRequest{
    private BigDecimal price;
    private BigDecimal priceSale;
    private int amount;
    private int status;
    private Integer productId;
}
