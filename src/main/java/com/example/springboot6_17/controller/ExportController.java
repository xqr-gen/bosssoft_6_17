package com.example.springboot6_17.controller;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot6_17.common.ResultResponse;
import com.example.springboot6_17.pojo.dto.UserExportDTO;
import com.example.springboot6_17.pojo.po.UserPO;
import com.example.springboot6_17.pojo.vo.UserExportVO;
import com.example.springboot6_17.service.impl.ExportServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: xqr
 * @Date: 2021/6/20 19:28
 */
@RestController
@Slf4j
public class ExportController {
    @Autowired
    private ExportServiceImpl exportService;

    @PostMapping("/exportFromMysql")
    public ResultResponse exportFromMysql(@RequestBody @Validated UserExportVO userExportVO){
        ResultResponse resultResponse=new ResultResponse();
        UserExportDTO userExportDTO=new UserExportDTO();
        BeanUtil.copyProperties(userExportVO,userExportDTO);
        /*待写 一个记录导出操作时间、操作人、、、、的服务
        exportService.UserExport----

         */

        Page<UserPO> page0=new Page<>(1,1000000);
        IPage<UserPO> iPage0=exportService.selectPageText(page0);
        long count = iPage0.getTotal();
        // xlsx文件中一个sheet做多100多点w行
        long sheetAllNum=count % 1000000== 0 ? count / 1000000: count / 1000000 + 1;

        String path="C:\\Users\\DELL\\Desktop\\1.xlsx";

        ExcelWriter excelWriter =EasyExcel.write(path, UserPO.class).build();
        for(int i=1;i<=sheetAllNum;i++){
            Page<UserPO> page=new Page<>(i,1000000);
            IPage<UserPO> iPage=exportService.selectPageText(page);
            List<UserPO> mpUserList1 = iPage.getRecords();
            WriteSheet writeSheet=EasyExcel.writerSheet("test"+i).build();
            excelWriter.write(mpUserList1,writeSheet);
        }




        excelWriter.finish();

        return resultResponse;
    }

}
