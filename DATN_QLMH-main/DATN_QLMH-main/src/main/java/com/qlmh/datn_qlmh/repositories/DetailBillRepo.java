package com.qlmh.datn_qlmh.repositories;

import com.qlmh.datn_qlmh.entities.DetailBillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DetailBillRepo extends JpaRepository<DetailBillEntity, Integer>, JpaSpecificationExecutor<DetailBillEntity> {
}