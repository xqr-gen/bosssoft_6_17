package com.example.springboot6_17.pojo.vo;





import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 *
 * @Author: xqr
 * @Date: 2021/6/19 21:14
 */
public class UploadFileVO {
    @NotNull(message = "上传人id不为空")
    private int uid;
    @Past(message = "穿越者？")
    private Date uploadFileDate;



}
