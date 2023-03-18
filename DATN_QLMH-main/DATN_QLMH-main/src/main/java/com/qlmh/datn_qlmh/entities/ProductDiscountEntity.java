package com.qlmh.datn_qlmh.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Table(name = "product_discount")
@Getter
@Setter

public class ProductDiscountEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "discount_id")
    private Long discountId;
}
