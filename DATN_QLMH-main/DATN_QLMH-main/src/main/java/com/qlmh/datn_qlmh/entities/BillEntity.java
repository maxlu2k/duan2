package com.qlmh.datn_qlmh.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
@Entity
@Table(name = "bill")
public class BillEntity extends BaseEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    @Column(name = "transport_fee")
    private BigDecimal transportFee;
    @Column(name = "customer_money")
    private BigDecimal customerMoney;
    @Column
    private BigDecimal discount;
    @Column
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @Column(name = "note")
    private String note;
    @Column(name = "full_name")
    private String fullName;
    @Column
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "type_of_bill")
    private int TypeOfBill;
    @Column(name = "voucher_id")
    private Integer voucherId;
    @Column(name = "discount_id")
    private Integer discountId;
    @Column(name = "username")
    private String username;
    @Column
    private BigDecimal total;
    @Column(name = "total_deposit")
    private BigDecimal totalDeposit;

    @AllArgsConstructor
    @Getter
    public enum PaymentMethod {
        MONEY,
        CARD,
        CARD_MONEY
    }

    @AllArgsConstructor
    @Getter
    public enum StatusEnum {
        HOA_DON_CHO,
        CHO_XAC_NHAN,
        XAC_NHAN,
        DANG_GIAO,
        DA_GIAO,
        HUY
    }

}
