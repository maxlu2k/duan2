package com.qlmh.datn_qlmh.services;

import com.qlmh.datn_qlmh.dtos.request.ProductReq;
import com.qlmh.datn_qlmh.dtos.response.ProductResp;

import java.util.List;

public interface ProductService {
    List<ProductResp> getAllProducts();
    List<ProductResp> getProductByTitle(Integer title);
    ProductReq create(ProductReq product);
    ProductReq update(ProductReq product);
    ProductResp getByID(Integer id);
}
