package com.qlmh.datn_qlmh.dtos.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RateReq {
    private Integer id;
    private Integer rate;
    private String comment;
    private boolean color;
    private boolean wrongProduct;
    private boolean lackOfAccessories;
    private boolean material;
    private Integer detailBillID;
    private Integer productID;
    private String userName;
}
