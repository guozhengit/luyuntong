package com.aygxy.xmf.mybatis.mapper;

import com.aygxy.xmf.mybatis.entity.PhysicalDepartmentInfo;

public interface PhysicalDepartmentInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhysicalDepartmentInfo record);

    int insertSelective(PhysicalDepartmentInfo record);

    PhysicalDepartmentInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhysicalDepartmentInfo record);

    int updateByPrimaryKey(PhysicalDepartmentInfo record);
}