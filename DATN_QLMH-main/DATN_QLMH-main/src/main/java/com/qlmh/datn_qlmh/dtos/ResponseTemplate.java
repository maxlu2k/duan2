package com.qlmh.datn_qlmh.dtos;

import com.qlmh.datn_qlmh.exceptions.model.ErrorResponse;
import org.springframework.http.HttpStatus;

public class ResponseTemplate {
    private static Byte ERROR_CODE = 99;
    public static ErrorResponse SUCCESS = new ErrorResponse(HttpStatus.OK.value(), "OK");
    public static ErrorResponse CREATED = new ErrorResponse(HttpStatus.CREATED.value(),"CREATED");
    public static ErrorResponse UNDEFINED_ERROR = new ErrorResponse(ERROR_CODE,"GENERIC ERROR");

    public static ErrorResponse NOT_FOUND(String message) {
        return new ErrorResponse(404,message);
    }
}
