package com.aygxy.xmf.mybatis.mapper;

import com.aygxy.xmf.mybatis.entity.PhysicalUserInfo;

public interface PhysicalUserInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhysicalUserInfo record);

    int insertSelective(PhysicalUserInfo record);

    PhysicalUserInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhysicalUserInfo record);

    int updateByPrimaryKey(PhysicalUserInfo record);
}