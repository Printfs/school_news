package com.feifan.exception;


import com.feifan.common.ServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(Exception.class)
//    public ServletResponse handleException(Exception e) {
//        System.out.println(e.getMessage());
//        return ServletResponse.createByErrorMessage(e.getMessage());
//    }
}
