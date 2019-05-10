package com.aygxy.mybatis.mapper;

import com.aygxy.mybatis.entity.PhysicalEmployeeInfo;

public interface PhysicalEmployeeInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhysicalEmployeeInfo record);

    int insertSelective(PhysicalEmployeeInfo record);

    PhysicalEmployeeInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhysicalEmployeeInfo record);

    int updateByPrimaryKey(PhysicalEmployeeInfo record);
}