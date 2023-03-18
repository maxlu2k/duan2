package com.qlmh.datn_qlmh.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Column(name = "create_date")
    protected Date createDate;
    @Column(name = "update_date")
    protected Date updateDate;
    @Column(name = "create_by")
    protected String createBy;
    @Column(name = "update_by")
    protected String updateBy;
}
