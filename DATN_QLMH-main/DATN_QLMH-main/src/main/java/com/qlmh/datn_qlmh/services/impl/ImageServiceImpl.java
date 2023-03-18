package com.qlmh.datn_qlmh.services.impl;

import com.qlmh.datn_qlmh.dtos.request.ImageReq;
import com.qlmh.datn_qlmh.dtos.response.ImageResp;
import com.qlmh.datn_qlmh.entities.ImageEntity;
import com.qlmh.datn_qlmh.repositories.ImageRepo;
import com.qlmh.datn_qlmh.services.ImageService;
import com.qlmh.datn_qlmh.services.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepo imageRepo;
    @Autowired
    Mapper mapper;
    @Override
    public List<ImageResp> getAll() {

        return imageRepo.findAll().stream().map((entity) -> mapper.toImageResp(entity)).collect(Collectors.toList());
    }

    @Override
    public ImageReq create(ImageReq imageReq) {
        ImageEntity imageEntity = mapper.toImageEntity(imageReq);
        imageEntity = imageRepo.save(imageEntity);
        return mapper.toImageReq(imageEntity);
    }

    @Override
    public ImageReq update(ImageReq imageReq) {
        if (imageReq.getId() == null){
            return null;
        }
        ImageEntity imageEntity = mapper.toImageEntity(imageReq);
        imageEntity = imageRepo.save(imageEntity);
        return mapper.toImageReq(imageEntity);
    }

    @Override
    public ImageReq getById(Integer id) {
        Optional<ImageEntity> imageEntity = imageRepo.findById(id);
        if (imageEntity.isPresent()){
            return mapper.toImageReq(imageEntity.get());
        }
        return null;
    }

    @Override
    public List<ImageReq> getImageByProductID(Integer productID) {

        return imageRepo.getImageByProductID(productID).stream().map((entity) -> mapper.toImageReq(entity)).collect(Collectors.toList());
    }
}
