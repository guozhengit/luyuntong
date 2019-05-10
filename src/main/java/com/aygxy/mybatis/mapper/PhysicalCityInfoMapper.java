package com.aygxy.mybatis.mapper;

import com.aygxy.mybatis.entity.PhysicalCityInfo;

public interface PhysicalCityInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhysicalCityInfo record);

    int insertSelective(PhysicalCityInfo record);

    PhysicalCityInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhysicalCityInfo record);

    int updateByPrimaryKey(PhysicalCityInfo record);
}