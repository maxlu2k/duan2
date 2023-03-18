package com.qlmh.datn_qlmh.dtos.response;

import com.qlmh.datn_qlmh.dtos.Items.BaseItems;
import lombok.Data;

@Data
public class DetailCartResponse extends BaseItems {
    private Integer id;
    private Integer cartId;
    private int amount;
    private Integer productId;
}
