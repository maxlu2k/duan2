package com.qlmh.datn_qlmh.services.impl;

import com.qlmh.datn_qlmh.dtos.request.ReturnReq;
import com.qlmh.datn_qlmh.entities.ReturnFigureEntity;
import com.qlmh.datn_qlmh.exceptions.InvalidArgumentException;
import com.qlmh.datn_qlmh.exceptions.NotFoundException;
import com.qlmh.datn_qlmh.repositories.ReturnRepository;
import com.qlmh.datn_qlmh.services.ReturnService;
import com.qlmh.datn_qlmh.services.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReturnServiceImpl implements ReturnService {
    @Autowired
    ReturnRepository returnRepository;
    @Autowired
    Mapper returnMapper;
    @Override
    public ReturnReq create(ReturnReq returnReq) {
        ReturnFigureEntity returnFigureEntity = returnMapper.toReturnFigureEntity(returnReq);
        returnFigureEntity = returnRepository.save(returnFigureEntity);
        return returnMapper.toReturnReq(returnFigureEntity);
    }

    @Override
    public ReturnReq update(ReturnReq returnReq) {
        if (returnReq.getId() == null) throw new InvalidArgumentException("id is not null ");
        ReturnFigureEntity returnFigure = returnRepository.findById(returnReq.getId()).orElseThrow(() -> new NotFoundException("Not found : " + returnReq.getId()));
        returnFigure = returnMapper.toReturnFigureEntity(returnReq);
        returnFigure = returnRepository.save(returnFigure);
        return returnMapper.toReturnReq(returnFigure);

    }
    @Override
    public List<ReturnReq> getAll() {
        return returnRepository.findAll().stream().map((entity) -> returnMapper.toReturnReq(entity)).collect(Collectors.toList());
    }
    @Override
    public ReturnReq getById(Integer id) {
        ReturnFigureEntity FigureEntity = returnRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found: " + id));
        return returnMapper.toReturnReq(FigureEntity);
//        Optional<ReturnFigureEntity> optional = returnRepository.findById(id);
//        if (optional.isPresent()) {
//            ReturnFigureEntity entity = optional.get();
//            List<ReturnFigureEntity> list = new ArrayList<>();
//            list.add(entity);
//            return list;
//        }
//        return new ArrayList<>();
        //Trong JPA, hàm findById trả về một Optional
        // chứa một đối tượng hoặc trả về một Optional trống nếu không tìm thấy bản ghi trong database.
    }
}
