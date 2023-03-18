package com.qlmh.datn_qlmh.controllers;

import com.qlmh.datn_qlmh.dtos.Response;
import com.qlmh.datn_qlmh.dtos.ResponseTemplate;
import com.qlmh.datn_qlmh.dtos.request.DiscountReq;
import com.qlmh.datn_qlmh.exceptions.model.ErrorResponse;
import com.qlmh.datn_qlmh.services.DiscountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/discount")
public class DiscountController {
    @Autowired
    private DiscountService discountService;
    @GetMapping("/get-all")
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(new Response(Calendar.getInstance().getTime(), ResponseTemplate.SUCCESS,discountService.findAll()));

    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new Response(Calendar.getInstance().getTime(), ResponseTemplate.SUCCESS,discountService.findById(id)));
    }
    @PostMapping("/new")
    public ResponseEntity<Response> addDiscount(@Valid @RequestBody DiscountReq DiscountReq) {
        return ResponseEntity.ok(new Response(Calendar.getInstance().getTime(), ResponseTemplate.CREATED,discountService.save(DiscountReq)));
    }
    @PutMapping("/update")
    public ResponseEntity<Response> updateDiscount(@Valid @RequestBody DiscountReq DiscountReq) {
        return ResponseEntity.ok(new Response(Calendar.getInstance().getTime(), ResponseTemplate.SUCCESS,discountService.update(DiscountReq)));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") Long id) {
        discountService.delete(id);
        return ResponseEntity.ok(new Response(Calendar.getInstance().getTime(), new ErrorResponse(HttpStatus.OK.value(), "Discount has been deleted")));

    }
}
