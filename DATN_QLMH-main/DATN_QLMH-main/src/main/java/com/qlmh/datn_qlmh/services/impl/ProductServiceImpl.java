package com.qlmh.datn_qlmh.services.impl;

import com.qlmh.datn_qlmh.dtos.request.ProductReq;
import com.qlmh.datn_qlmh.dtos.response.ProductResp;
import com.qlmh.datn_qlmh.entities.ImageEntity;
import com.qlmh.datn_qlmh.entities.ProductEntity;
import com.qlmh.datn_qlmh.repositories.ImageRepo;
import com.qlmh.datn_qlmh.repositories.ProductRepo;
import com.qlmh.datn_qlmh.services.ProductService;
import com.qlmh.datn_qlmh.services.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    Mapper mapper;
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    ImageRepo imageRepo;

    @Override
    public List<ProductResp> getAllProducts() {

        List<ProductResp> list = productRepo.findAll().stream().map((entity) -> mapper.toProductResp(entity)).collect(Collectors.toList());
        for (ProductResp productResp : list) {
            List<ImageEntity> listimgs = imageRepo.getImageByProductID(productResp.getId());
            productResp.setListImage(listimgs);
        }
        return list;
    }

    @Override
    public List<ProductResp> getProductByTitle(Integer title) {

        return productRepo.getProductsByTitle(title).stream().map((entity) -> mapper.toProductResp(entity)).collect(Collectors.toList());
    }

    @Override
    public ProductReq create(ProductReq product) {
        ProductEntity productEntity = mapper.toProductEntity(product);
        productEntity = productRepo.save(productEntity);
        return mapper.toProductReq(productEntity);
    }

    @Override
    public ProductReq update(ProductReq product) {
        if (product.getId() == null) {
            return null;
        }
        ProductEntity productEntity = mapper.toProductEntity(product);
        productEntity = productRepo.save(productEntity);
        return mapper.toProductReq(productEntity);
    }


    @Override
    public ProductResp getByID(Integer id) {
        Optional<ProductEntity> productEntity = productRepo.findById(id);
        if (productEntity.isPresent()) {
            return mapper.toProductResp(productEntity.get());
        }
        return null;
    }
}
