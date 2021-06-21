package com.example.springboot6_17.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: xqr
 * @Date: 2021/6/19 14:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultResponse {


    private int code;
    private String message;
    private Object data;





}
