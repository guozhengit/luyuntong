package com.aygxy.xmf.mybatis.mapper;

import com.aygxy.xmf.mybatis.entity.PhysicalSTypegroup;

public interface PhysicalSTypegroupMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhysicalSTypegroup record);

    int insertSelective(PhysicalSTypegroup record);

    PhysicalSTypegroup selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhysicalSTypegroup record);

    int updateByPrimaryKey(PhysicalSTypegroup record);
}