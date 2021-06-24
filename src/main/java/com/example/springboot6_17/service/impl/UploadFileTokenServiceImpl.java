package com.example.springboot6_17.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.example.springboot6_17.common.CommonOss;
import com.example.springboot6_17.pojo.dto.UploadFileTokenDTO;
import com.example.springboot6_17.service.UploadFileTokenService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 签名直传
 * @Author: xqr
 * @Date: 2021/6/23 21:42
 */
@Service
public class UploadFileTokenServiceImpl implements UploadFileTokenService {
    @Override
    public UploadFileTokenDTO UploadFileToken(MultipartFile file) {
        OSS ossClient = new OSSClientBuilder().build(CommonOss.endpoint, CommonOss.accessId, CommonOss.accessKey);
        UploadFileTokenDTO uploadFileTokenDTO=new UploadFileTokenDTO();
        // host的格式为 bucketname.endpoint

        String host = "https://" + CommonOss.bucket + "." + CommonOss.endpoint;
        try{
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            // 用户上传文件时指定的前缀。

            String dir = format + "/";
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);
            String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = ossClient.calculatePostSignature(postPolicy);
            uploadFileTokenDTO.setAccessId(CommonOss.accessId);
            uploadFileTokenDTO.setEncodedPolicy(encodedPolicy);
            uploadFileTokenDTO.setPostSignature(postSignature);
            uploadFileTokenDTO.setDir(dir);
            uploadFileTokenDTO.setHost(host);
            uploadFileTokenDTO.setExpireTime(String.valueOf(expireEndTime / 1000));
        }catch (Exception e){
            return null;
        }finally {
            ossClient.shutdown();
        }
        return uploadFileTokenDTO;
    }
}
