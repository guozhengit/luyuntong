package com.aygxy.xmf.mybatis.mapper;

import com.aygxy.xmf.mybatis.entity.PhysicalDetilPaymentInfo;

public interface PhysicalDetilPaymentInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhysicalDetilPaymentInfo record);

    int insertSelective(PhysicalDetilPaymentInfo record);

    PhysicalDetilPaymentInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhysicalDetilPaymentInfo record);

    int updateByPrimaryKey(PhysicalDetilPaymentInfo record);
}