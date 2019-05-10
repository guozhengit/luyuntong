package com.aygxy.mybatis.mapper;

import com.aygxy.mybatis.entity.PhysicalDriverInfo;

public interface PhysicalDriverInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhysicalDriverInfo record);

    int insertSelective(PhysicalDriverInfo record);

    PhysicalDriverInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhysicalDriverInfo record);

    int updateByPrimaryKey(PhysicalDriverInfo record);
}