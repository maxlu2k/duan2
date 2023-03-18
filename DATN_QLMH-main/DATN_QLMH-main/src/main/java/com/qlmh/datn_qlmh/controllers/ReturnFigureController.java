package com.qlmh.datn_qlmh.controllers;

import com.qlmh.datn_qlmh.dtos.request.ReturnReq;
import com.qlmh.datn_qlmh.entities.ReturnFigureEntity;
import com.qlmh.datn_qlmh.services.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/return")
public class ReturnFigureController {
    @Autowired
    private  ReturnService returnService;

    @GetMapping("/getAll")
    public List<ReturnReq> getAll(){
        return returnService.getAll();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ReturnReq> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(returnService.getById(id));
    }
    @PostMapping("/insert")
    public ResponseEntity<ReturnReq> insert(@RequestBody ReturnReq returnReq) {
        return ResponseEntity.ok(returnService.create(returnReq)) ;
    }

    @PutMapping("/update")
    public ResponseEntity<ReturnReq> update(@RequestBody ReturnReq returnReq) {
        return ResponseEntity.ok(returnService.update(returnReq)) ;
    }
    @PutMapping("/updateStatus")
    public ResponseEntity<ReturnReq> updateStatus(@RequestBody ReturnReq returnReq) {
        return ResponseEntity.ok(returnService.update(returnReq)) ;
    }

}
