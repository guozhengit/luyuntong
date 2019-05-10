package com.aygxy.mybatis.mapper;

import com.aygxy.mybatis.entity.PhysicalDetilGoodsInfo;

public interface PhysicalDetilGoodsInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhysicalDetilGoodsInfo record);

    int insertSelective(PhysicalDetilGoodsInfo record);

    PhysicalDetilGoodsInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhysicalDetilGoodsInfo record);

    int updateByPrimaryKey(PhysicalDetilGoodsInfo record);
}