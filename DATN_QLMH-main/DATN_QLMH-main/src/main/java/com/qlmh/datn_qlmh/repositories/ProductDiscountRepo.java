package com.qlmh.datn_qlmh.repositories;

import com.qlmh.datn_qlmh.entities.ProductDiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductDiscountRepo extends JpaRepository<ProductDiscountEntity,Long> {
//    @Query("SELECT pd FROM ProductDiscountEntity pd WHERE pd.discountEntity.id := id")
//    List<ProductDiscountEntity> getByDiscountId(@Param("id") Long id);
}
