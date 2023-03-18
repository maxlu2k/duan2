package com.qlmh.datn_qlmh.controllers;

import com.qlmh.datn_qlmh.dtos.request.RateImgReq;
import com.qlmh.datn_qlmh.dtos.request.RateReq;
import com.qlmh.datn_qlmh.dtos.response.RateRes;
import com.qlmh.datn_qlmh.services.RateImgService;
import com.qlmh.datn_qlmh.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/rate")
public class RateController {
    @Autowired
    RateService rateService;

    @Autowired
    RateImgService rateImgService;

    @GetMapping("/get-by-productid")
    public List<RateRes> listProducts(@RequestParam("product-id") Integer projectId) {
        List<RateRes> products = rateService.getByProductID(projectId);
        return products;

    }

    @GetMapping("/getById")
    public RateRes getById(@RequestParam("rate-id") Integer rateId) {
        return rateService.getByID(rateId);

    }

    @GetMapping("/get-all")
    public List<RateRes> getAll() {
        return rateService.getAll();
    }

    @PostMapping("/craete")
    public RateRes create(@RequestBody RateReq rateReq) {
        return rateService.create(rateReq);
    }

    @PutMapping("/update")
    public RateRes update(@RequestBody RateReq rateReq) {
        return rateService.update(rateReq);
    }

    @PostMapping("/create-img")
    public RateImgReq craeteImg(@RequestBody RateImgReq rateImgReq) {
        return rateImgService.create(rateImgReq);
    }

    @PutMapping("/update-img")
    public RateImgReq updateImg(@RequestBody RateImgReq rateImgReq) {
        return rateImgService.update(rateImgReq);
    }

    @GetMapping("/get-by-rateid")
    public List<RateImgReq> getImgByRate(@RequestParam("id") Integer id) {
        System.out.println(id);
        return rateImgService.getByRateID(id);
    }

    @GetMapping("/get-by-id")
    public RateImgReq getImgById(@RequestParam("id") Integer id) {
        return rateImgService.getById(id);

    }


}
