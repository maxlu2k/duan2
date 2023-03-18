package com.qlmh.datn_qlmh.controllers;
import com.qlmh.datn_qlmh.dtos.Response;
import com.qlmh.datn_qlmh.dtos.ResponseTemplate;
import com.qlmh.datn_qlmh.dtos.request.CartRequest;
import com.qlmh.datn_qlmh.dtos.response.CartResponse;
import com.qlmh.datn_qlmh.dtos.response.DetailCartResponse;
import com.qlmh.datn_qlmh.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/cart")
public class CartController {
    @Autowired
    private ICartService iCartService;
    @GetMapping(value = "/{user_name}", produces = "application/json")
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<?> getListCartDetailByCartId(@PathVariable("user_name") String userName) {
        CartResponse getCartResponse = iCartService.findById(userName);
        return ResponseEntity.ok(new Response(Calendar.getInstance().getTime(), ResponseTemplate.SUCCESS, getCartResponse));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCart( @RequestBody CartRequest request) {
        DetailCartResponse cartDetailDTO = iCartService.addToCart(request);

        return ResponseEntity.ok(cartDetailDTO);
    }

    @DeleteMapping(value="/{id}",produces = "application/json")
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<?> deleteCart(@PathVariable("id") Integer id) {
        DetailCartResponse cartDetailDTO = iCartService.delete(id);
        return ResponseEntity.ok(new Response(Calendar.getInstance().getTime(), ResponseTemplate.SUCCESS, cartDetailDTO));
    }

    @PutMapping("/update/{id}")
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<?> updateCart(@PathVariable("id") Integer id, @RequestParam("amount") int amount) {
        DetailCartResponse cartDetailDTO = iCartService.update(id, amount);
        return ResponseEntity.ok(new Response(Calendar.getInstance().getTime(), ResponseTemplate.SUCCESS, cartDetailDTO));
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<?> deleteCartDetailByUserId(@Validated @RequestBody List<Integer> id) {
        DetailCartResponse cartDetailDTO = iCartService.deleteListCart(id);
        return ResponseEntity.ok(cartDetailDTO);
    }
    @DeleteMapping("/list/delete/{user_name}")
    public ResponseEntity<?> deleteCartDetailByUserId(@PathVariable("user_name") String user_name) {
        DetailCartResponse cartDetailDTO = iCartService.deleteAllCart(user_name);
        return ResponseEntity.ok(cartDetailDTO);
    }

}
