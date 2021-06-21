package com.example.springboot6_17.service;

import com.example.springboot6_17.pojo.dto.UploadFileDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: xqr
 * @Date: 2021/6/19 22:13
 */

public interface UploadFileService {
    /**
     * oss 提供的分片上传
     * @Param: []
     * @Return: boolean
     */
    public UploadFileDTO uploadFile(MultipartFile file,UploadFileDTO uploadFileDTO) throws IOException;


}
