package com.aygxy.xmf.mybatis.mapper;

import com.aygxy.xmf.mybatis.entity.PhysicalMenuInfo;

public interface PhysicalMenuInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhysicalMenuInfo record);

    int insertSelective(PhysicalMenuInfo record);

    PhysicalMenuInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhysicalMenuInfo record);

    int updateByPrimaryKey(PhysicalMenuInfo record);
}