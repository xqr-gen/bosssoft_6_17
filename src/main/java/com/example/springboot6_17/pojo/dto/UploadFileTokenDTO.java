package com.example.springboot6_17.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 签名直传   并回调   (这次没做完回调)
 * @Author: xqr
 * @Date: 2021/6/23 22:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadFileTokenDTO {
        private String accessId;
        private String encodedPolicy;
        private String postSignature;
        private String dir;
        private String host;
        private String expireTime;

        // 回调的

        private String base64CallbackBody;
}
