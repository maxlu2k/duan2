package com.qlmh.datn_qlmh.dtos.request;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageReq {
    private Integer id;
    private String url;
    private Integer productID;
}
