package com.qlmh.datn_qlmh.controllers;
import com.qlmh.datn_qlmh.dtos.request.ProductReq;
import com.qlmh.datn_qlmh.dtos.response.CategoriesResp;
import com.qlmh.datn_qlmh.dtos.response.ProductResp;
import com.qlmh.datn_qlmh.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("api/products")
public class ProductsController {
    @Autowired
    ProductService productService;

    @GetMapping()
    public ResponseEntity<List<ProductResp>> getAll(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping()
    public ResponseEntity<ProductReq> create(@RequestBody ProductReq productReq){
        return ResponseEntity.ok(productService.create(productReq));
    }

    @PutMapping()
    public ResponseEntity<ProductReq> update(@RequestBody ProductReq productReq){
        return ResponseEntity.ok(productService.update(productReq));
    }
    @GetMapping("title")
    public ResponseEntity<List<ProductResp>> getAllByTitle(@RequestParam("id") Integer id){
        return ResponseEntity.ok(productService.getProductByTitle(id));
    }
    @GetMapping("detail")
    public ResponseEntity<ProductResp> getByID( @RequestParam("id") Integer id ){
        return ResponseEntity.ok(productService.getByID(id));
    }

}
