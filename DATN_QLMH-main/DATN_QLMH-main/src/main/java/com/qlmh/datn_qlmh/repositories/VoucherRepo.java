package com.qlmh.datn_qlmh.repositories;

import com.qlmh.datn_qlmh.entities.VoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoucherRepo extends JpaRepository<VoucherEntity,Long> {

}
