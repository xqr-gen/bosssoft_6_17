package com.example.springboot6_17.service;

import com.example.springboot6_17.pojo.dto.UploadFileTokenDTO;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 *签名直传
 * @Author: xqr
 * @Date: 2021/6/23 21:47
 */
public interface UploadFileTokenService {

    public UploadFileTokenDTO UploadFileToken(MultipartFile file);

}
