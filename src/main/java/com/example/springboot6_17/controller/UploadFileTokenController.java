package com.example.springboot6_17.controller;

import com.example.springboot6_17.common.ResultException;
import com.example.springboot6_17.common.ResultResponse;
import com.example.springboot6_17.pojo.dto.UploadFileTokenDTO;
import com.example.springboot6_17.service.impl.UploadFileTokenServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *       签名直传
 * @Author: xqr
 * @Date: 2021/6/23 21:48
 */
@RestController
@Slf4j
public class UploadFileTokenController {
    @Autowired
    private UploadFileTokenServiceImpl uploadFileTokenService;


    @GetMapping("/UT")
    public ResultResponse UploadFileToken(MultipartFile file){
        ResultResponse resultResponse=new ResultResponse();
        UploadFileTokenDTO uploadFileTokenDTO=uploadFileTokenService.UploadFileToken(file);
        if(uploadFileTokenDTO!=null){
            resultResponse.setCode(20000);
            resultResponse.setMessage("上传成功");
            resultResponse.setData(uploadFileTokenDTO);
        }else {
            throw new ResultException();
        }
        return resultResponse;
    }

}
