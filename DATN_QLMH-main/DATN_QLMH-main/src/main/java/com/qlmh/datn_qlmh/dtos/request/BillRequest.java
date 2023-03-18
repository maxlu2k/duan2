package com.qlmh.datn_qlmh.dtos.request;

import com.qlmh.datn_qlmh.dtos.Items.BaseItems;
import com.qlmh.datn_qlmh.entities.BillEntity;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
public class BillRequest extends BaseItems {

    @NotNull(message = "Trạng thái không để trống")
    private BillEntity.StatusEnum status;
    @NotNull(message = "Phí vận chuyển không để trống")
    private BigDecimal transportFee;
    @NotNull
    private BigDecimal customerMoney;
    private BigDecimal discount;
    @NotNull(message = "Phương thức thanh toán không để trống")
    private BillEntity.PaymentMethod paymentMethod;
    private String note;
    private String fullName;
    @NotNull(message = "Địa chỉ không để trống")
    private String address;
    @NotNull(message = "Số điện thoại không được để trống")
    private String phoneNumber;
    private int TypeOfBill;
    private Integer voucherId;
    private Integer discountId;
    @NotNull(message = "Người dùng không để trống")
    private String username;
    @NotNull(message = "Tổng tiền không để trống")
    private BigDecimal total;
    private String voucherCode;
    private BigDecimal totalDeposit;
    private List<BillRequest.DetailBillRequest> detailBillRequests;

    @Data
    @Valid
    public static class DetailBillRequest extends BaseItems{
        private BigDecimal price;
        private BigDecimal priceSale;
        private BigDecimal discount;
        private int amount;
        private int status;
        private Integer discountId;
        private Integer productId;
        private Integer billId;
        private int TypeOfBill;
        private BigDecimal deposit;

    }

}
