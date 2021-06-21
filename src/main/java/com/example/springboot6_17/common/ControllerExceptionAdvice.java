package com.example.springboot6_17.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: xqr
 * @Date: 2021/6/19 14:10
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionAdvice {
    @ExceptionHandler
    @ResponseBody
    public Object exceptionHandler(ResultException e){
        log.error("",e);
        return new ResultResponse(e.getCode(),e.getMessage(),null);
    }


}
