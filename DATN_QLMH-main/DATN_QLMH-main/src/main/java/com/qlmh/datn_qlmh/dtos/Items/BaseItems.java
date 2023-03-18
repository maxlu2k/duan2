package com.qlmh.datn_qlmh.dtos.Items;

import lombok.Data;

import java.util.Date;
@Data
public class BaseItems {
    protected Date createDate;
    protected Date updateDate;
    protected String createBy;
    protected String updateBy;
}
