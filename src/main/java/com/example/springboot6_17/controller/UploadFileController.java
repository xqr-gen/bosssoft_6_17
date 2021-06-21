package com.example.springboot6_17.controller;


import cn.hutool.core.bean.BeanUtil;
import com.example.springboot6_17.common.ResultException;
import com.example.springboot6_17.common.ResultResponse;

import com.example.springboot6_17.pojo.dto.UploadFileDTO;
import com.example.springboot6_17.pojo.vo.UploadFileVO;

import com.example.springboot6_17.service.impl.UploadFileServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: xqr
 * @Date: 2021/6/19 21:15
 */

@Slf4j
@RestController
public class UploadFileController {
    /*
    @Autowired
    private UploadFileServiceImpl uploadFileService;

    @PostMapping
    public ResultResponse uploadFile(MultipartFile file, @RequestBody @Validated UploadFileVO uploadFileVo) throws IOException {
        ResultResponse resultResponse=new ResultResponse();


        UploadFileDTO uploadFileDTO=new UploadFileDTO();
        BeanUtil.copyProperties(uploadFileVo,uploadFileDTO);

        UploadFileDTO uploadFileDTO2=uploadFileService.uploadFile(file,uploadFileDTO);

        if(uploadFileDTO2 != null){
            resultResponse.setCode(20000);
            resultResponse.setMessage("上传成功");
            resultResponse.setData(uploadFileDTO);
        }else{
            throw new ResultException();
        }

        return resultResponse;
    }

*/
}
