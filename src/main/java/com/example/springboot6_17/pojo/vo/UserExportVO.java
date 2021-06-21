package com.example.springboot6_17.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 记录操作人ID
 * @Author: xqr
 * @Date: 2021/6/20 20:12
 */
@Data
public class UserExportVO {
    @NotNull(message = "")
    private Integer id;
}
