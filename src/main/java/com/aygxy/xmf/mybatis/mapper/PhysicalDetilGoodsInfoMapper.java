package com.aygxy.xmf.mybatis.mapper;

import com.aygxy.xmf.mybatis.entity.PhysicalDetilGoodsInfo;

public interface PhysicalDetilGoodsInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhysicalDetilGoodsInfo record);

    int insertSelective(PhysicalDetilGoodsInfo record);

    PhysicalDetilGoodsInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhysicalDetilGoodsInfo record);

    int updateByPrimaryKey(PhysicalDetilGoodsInfo record);
}