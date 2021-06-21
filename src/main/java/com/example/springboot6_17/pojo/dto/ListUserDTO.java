package com.example.springboot6_17.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: DEll
 * @Date: 2021/6/20 20:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListUserDTO {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
}
