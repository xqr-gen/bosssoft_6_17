package com.example.springboot6_17.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot6_17.pojo.po.UserPO;



/**
 * @Author: xqr
 * @Date: 2021/6/20 19:29
 */

public interface ExportService extends IService<UserPO> {
    IPage<UserPO> selectPageText(Page<UserPO> page);
}