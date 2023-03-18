package com.qlmh.datn_qlmh.entities;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
@MappedSuperclass

public class BaseDiscountEntity implements Serializable {
    @Column(name = "discount_start")
    protected Date discountStart;
    @Column(name = "discount_end")
    protected Date discountEnd;
    @Column(name = "discount_type")
    protected Byte discountType;
    @Column(name = "discount_amount")
    protected BigDecimal discountAmount;
}
