package com.qlmh.datn_qlmh.controllers;

import com.qlmh.datn_qlmh.dtos.Response;
import com.qlmh.datn_qlmh.dtos.ResponseTemplate;
import com.qlmh.datn_qlmh.dtos.request.BillRequest;
import com.qlmh.datn_qlmh.entities.DeliveryStatus;
import com.qlmh.datn_qlmh.services.impl.BillServiceImpl;
import com.qlmh.datn_qlmh.services.impl.DeliveryService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/bill")
public class OrderController {
    private final DeliveryService deliveryService;
    private final BillServiceImpl billService;
    @Autowired
    public OrderController(DeliveryService deliveryService, BillServiceImpl billService) {
        this.deliveryService = deliveryService;
        this.billService = billService;
    }

    @GetMapping("/orders")
    public String getOrderDetails() {
        return deliveryService.getOrderDetails();
    }
    @GetMapping("/delivery/{trackingNumber}")
    public DeliveryStatus getDeliveryStatus(@PathVariable String trackingNumber) {
        return deliveryService.getDeliveryStatus(trackingNumber);
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveOrder(@RequestBody @Valid BillRequest billRequest) {

        return ResponseEntity.ok(new Response(Calendar.getInstance().getTime(), ResponseTemplate.SUCCESS, billService.saveOrder(billRequest)));
    }
}
