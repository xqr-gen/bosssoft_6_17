package com.example.springboot6_17.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class OssConfig{

}

/**
 * @Author: DEll
 * @Date: 2021/6/21 9:47
 */
/*
@Configuration
@Slf4j
public class OssConfig implements DisposableBean {

    @Value("${aliyun.oss.end-point}")
    private String endpoint;
    @Value("${aliyun.oss.accesskey-id}")
    private String accessKeyId;
    @Value("${aliyun.oss.accesskey-secret}")
    private String accessKeySecret;

    /**
     * 注册阿里云oss客户端
     * @return oss客户端
     */
    /*
    @Bean
    public OSS ossClient(){
        return new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

    @Override
    public void destroy() throws Exception {
        ossClient().shutdown();
        log.info("容器销毁，oss关闭!");
    }

}
*/