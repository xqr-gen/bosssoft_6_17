package com.example.springboot6_17.service.impl;


import cn.hutool.core.date.DateTime;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import com.aliyun.oss.model.*;
import com.example.springboot6_17.common.CommonOss;
import com.example.springboot6_17.pojo.dto.UploadFileDTO;

import com.example.springboot6_17.service.UploadFileService;



import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @Author: xqr
 * @Date: 2021/6/19 22:13
 */
@Service
public class UploadFileServiceImpl implements UploadFileService {



    @Override
    public UploadFileDTO uploadFile(MultipartFile file, UploadFileDTO uploadFileDTO) throws IOException{
        OSS ossClient = new OSSClientBuilder().build(CommonOss.endpoint, CommonOss.accessId, CommonOss.accessKey);
        uploadFileDTO.setFileName(file.getOriginalFilename());
        String datePath = new DateTime().toString("yyyy/MM/dd");
        String objectName = CommonOss.filePathPrefix + datePath + "/" + file.getOriginalFilename();
        try {
            //初始化分片。
            InitiateMultipartUploadRequest request = new InitiateMultipartUploadRequest(CommonOss.bucket, objectName);
            InitiateMultipartUploadResult upresult = ossClient.initiateMultipartUpload(request);
            String uploadId = upresult.getUploadId();
            // partETags是PartETag的集合。PartETag由分片的ETag和分片号组成。
            List<PartETag> partETags = new ArrayList<PartETag>();
            long partSize = CommonOss.partSize;
            long fileSize = file.getSize();

            int partCount = (int) (fileSize / partSize);
            InputStream instream = file.getInputStream();
            // 遍历分片上传。
            for (int i = 0; i < partCount; i++) {
                long startPos = i * partSize;
                long curPartSize = (i + 1 == partCount) ? (fileSize - startPos) : partSize;

                // 跳过已经上传的分片。

                instream.skip(startPos);
                UploadPartRequest uploadPartRequest = new UploadPartRequest();
                uploadPartRequest.setBucketName(CommonOss.bucket);
                uploadPartRequest.setKey(objectName);
                uploadPartRequest.setUploadId(uploadId);
                uploadPartRequest.setInputStream(instream);
                // 设置分片大小。除了最后一个分片没有大小限制，其他的分片最小为100 KB。
                uploadPartRequest.setPartSize(curPartSize);
                // 设置分片号。每一个上传的分片都有一个分片号，取值范围是1~10000，如果超出这个范围，OSS将返回InvalidArgument的错误码。
                uploadPartRequest.setPartNumber(i + 1);
                // 每个分片不需要按顺序上传，甚至可以在不同客户端上传，OSS会按照分片号排序组成完整的文件。
                UploadPartResult uploadPartResult = ossClient.uploadPart(uploadPartRequest);
                // 每次上传分片之后，OSS的返回结果包含PartETag。PartETag将被保存在partETags中。
                partETags.add(uploadPartResult.getPartETag());
            }



            // 创建CompleteMultipartUploadRequest对象。
            // 在执行完成分片上传操作时，需要提供所有有效的partETags。OSS收到提交的partETags后，会逐一验证每个分片的有效性。当所有的数据分片验证通过后，OSS将把这些分片组合成一个完整的文件。
            CompleteMultipartUploadRequest completeMultipartUploadRequest =
                    new CompleteMultipartUploadRequest(CommonOss.bucket, objectName, uploadId, partETags);
            CompleteMultipartUploadResult completeMultipartUploadResult = ossClient.completeMultipartUpload(completeMultipartUploadRequest);
            // 设置URL过期时间为1小时。
            // Date expiration1 = new Date(new Date().getTime() + 3600 * 1000)
            Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000);
            // 生成以GET方法访问的签名URL，访客可以直接通过浏览器访问相关内容。
            URL url = ossClient.generatePresignedUrl(CommonOss.bucket, objectName, expiration);
            uploadFileDTO.setUrl(url.toString());
            uploadFileDTO.setObjectName(objectName);
            uploadFileDTO.setInputStreamPath(completeMultipartUploadResult.getLocation());
            uploadFileDTO.setClientCRC(completeMultipartUploadResult.getClientCRC());
            ossClient.shutdown();
        }catch (Exception e){
            uploadFileDTO=null;
        }

        return uploadFileDTO;
    }



}
