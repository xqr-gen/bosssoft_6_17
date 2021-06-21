package com.example.springboot6_17.pojo.po;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xqr
 * @Date: 2021/6/20 19:37
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPO {
    @ExcelProperty(index = 1,value = "id")
    private int id;
    @ExcelProperty(index = 2,value = "name")
    private String name;
    @ExcelProperty(index = 3,value = "age")
    private Integer age;
    @ExcelProperty(index = 4,value = "email")
    private String email;
    @ExcelIgnore
    private int version;
}
