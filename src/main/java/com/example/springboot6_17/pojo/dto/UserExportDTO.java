package com.example.springboot6_17.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: xqr
 * @Date: 2021/6/20 20:12
 */
@Data
public class UserExportDTO {
    @NotNull
    private Integer id;
}
