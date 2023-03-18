package com.qlmh.datn_qlmh.dtos.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseDiscount {
    @NotNull
    private Date discountStart;
    @NotNull
    private Date discountEnd;
    @NotNull
//    @Size(min = 0,max = 1)
    private Byte discountType;
    @NotNull
    private BigDecimal discountAmount;
}
