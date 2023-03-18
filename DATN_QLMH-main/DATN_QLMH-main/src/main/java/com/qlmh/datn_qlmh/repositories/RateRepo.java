package com.qlmh.datn_qlmh.repositories;

import com.qlmh.datn_qlmh.entities.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RateRepo extends JpaRepository<RateEntity, Integer> {
   @Query("SELECT p FROM RateEntity p WHERE p.productID=?1 ")
    List<RateEntity> findByProductID(Integer productID);
}
