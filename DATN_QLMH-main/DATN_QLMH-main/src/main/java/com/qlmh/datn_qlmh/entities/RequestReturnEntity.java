package com.qlmh.datn_qlmh.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "request_return_entity")
public class RequestReturnEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "")
    private String description;
    @Column(name = "")
    private Date creatDate = new Date();
    @Column(name = "")
    private Boolean paymentMethods;
    @Column(name = "")
    private String userName;
}
