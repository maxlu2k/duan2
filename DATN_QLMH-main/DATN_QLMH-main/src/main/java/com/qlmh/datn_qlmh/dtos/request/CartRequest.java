package com.qlmh.datn_qlmh.dtos.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CartRequest{
   private String userName;
   private int amount;
   private Integer productId;

}
