package com.example.springboot6_17.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot6_17.pojo.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: xqr
 * @Date: 2021/6/20 19:52
 */
@Mapper
@Repository
public interface UserMapperDao extends BaseMapper<UserPO> {
    @Select("select * from user")
    IPage<UserPO> selectPageText(Page<UserPO> page);
}
