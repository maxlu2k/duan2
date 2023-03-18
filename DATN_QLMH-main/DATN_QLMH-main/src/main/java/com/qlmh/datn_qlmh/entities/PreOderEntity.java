package com.qlmh.datn_qlmh.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
@Entity
@Table(name = "pre_oder")
public class PreOderEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "deposit")
    private BigDecimal deposit;
    @Column(name = "deposit_status")
    private int depositStatus;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @Column(name = "address")
    private String address;
    @Column(name = "status")
    private String status;
    @Column(name = "username")
    private String username;
}
