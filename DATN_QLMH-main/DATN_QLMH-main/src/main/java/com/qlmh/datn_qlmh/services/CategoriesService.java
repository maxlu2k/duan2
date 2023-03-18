package com.qlmh.datn_qlmh.services;

import com.qlmh.datn_qlmh.dtos.request.CategoriesReq;
import com.qlmh.datn_qlmh.dtos.response.CategoriesResp;

import java.util.List;
import java.util.Optional;

public interface CategoriesService {
    public CategoriesReq createCategory(CategoriesReq categoriesReq);
    public CategoriesReq updateCategory(CategoriesReq categoriesReq);
    public List<CategoriesResp> getAllCategories();
    public Optional<CategoriesReq> getCategoriesID(Integer categoryID);
    public CategoriesReq updateActive(CategoriesReq categoriesReq);
}
