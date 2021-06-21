package com.example.springboot6_17.pojo.dto;

import com.example.springboot6_17.common.CommonOss;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

/**
 *
 * @Author: xqr
 * @Date: 2021/6/19 23:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadFileDTO {

    private Integer uid;
    private Date uploadFileDate;
    private String fileName;
    private String ObjectName;
    //clientCRC 和 serverCRC 都传给前端去判断。

    private Long clientCRC;
    private Long serverCRC;

    private final String endpoint= CommonOss.endpoint;
    private String inputStreamPath;
}
