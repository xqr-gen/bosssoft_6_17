package com.example.springboot6_17.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot6_17.mapper.UserMapperDao;
import com.example.springboot6_17.pojo.dto.ListUserDTO;

import com.example.springboot6_17.pojo.po.UserPO;
import com.example.springboot6_17.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xqr
 * @Date: 2021/6/20 19:30
 */
@Service
public class ExportServiceImpl extends ServiceImpl<UserMapperDao, UserPO> implements ExportService {
    @Autowired
    private UserMapperDao userMapperdao;

    @Override
    public IPage<UserPO> selectPageText(Page<UserPO> page) {
        return baseMapper.selectPageText(page);

    }
}
