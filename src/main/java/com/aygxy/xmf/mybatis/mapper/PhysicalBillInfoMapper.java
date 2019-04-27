package com.aygxy.xmf.mybatis.mapper;

import com.aygxy.xmf.mybatis.entity.PhysicalBillInfo;

public interface PhysicalBillInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhysicalBillInfo record);

    int insertSelective(PhysicalBillInfo record);

    PhysicalBillInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhysicalBillInfo record);

    int updateByPrimaryKey(PhysicalBillInfo record);
}