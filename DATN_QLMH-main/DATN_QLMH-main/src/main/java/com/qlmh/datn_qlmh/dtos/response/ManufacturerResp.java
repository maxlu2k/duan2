package com.qlmh.datn_qlmh.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerResp {
    private Integer id;
    private String name;
    private Date createdDate = new Date();
    private String createBy;
    private String username;
}
