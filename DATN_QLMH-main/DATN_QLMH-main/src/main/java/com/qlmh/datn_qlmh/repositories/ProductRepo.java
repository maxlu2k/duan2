package com.qlmh.datn_qlmh.repositories;

import com.qlmh.datn_qlmh.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
    @Query("select p from ProductEntity p where  p.title =?1")
    List<ProductEntity> getProductsByTitle(Integer title);
    
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
    ProductEntity findByIdAndStatus(Integer id, int status);
}
