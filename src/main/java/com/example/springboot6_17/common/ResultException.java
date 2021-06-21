package com.example.springboot6_17.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xqr
 * @Date: 2021/6/19 15:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultException extends RuntimeException{
    private int code=200;
    private String message="出错了";
}
