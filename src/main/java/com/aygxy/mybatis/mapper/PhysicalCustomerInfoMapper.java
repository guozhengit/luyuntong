package com.aygxy.mybatis.mapper;

import com.aygxy.mybatis.entity.PhysicalCustomerInfo;

public interface PhysicalCustomerInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhysicalCustomerInfo record);

    int insertSelective(PhysicalCustomerInfo record);

    PhysicalCustomerInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhysicalCustomerInfo record);

    int updateByPrimaryKey(PhysicalCustomerInfo record);
}