package com.aygxy.xmf.mybatis.mapper;

import com.aygxy.xmf.mybatis.entity.PhysicalSType;

public interface PhysicalSTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhysicalSType record);

    int insertSelective(PhysicalSType record);

    PhysicalSType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhysicalSType record);

    int updateByPrimaryKey(PhysicalSType record);
}