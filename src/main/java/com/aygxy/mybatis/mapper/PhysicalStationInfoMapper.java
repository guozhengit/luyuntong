package com.aygxy.mybatis.mapper;

import com.aygxy.mybatis.entity.PhysicalStationInfo;

public interface PhysicalStationInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhysicalStationInfo record);

    int insertSelective(PhysicalStationInfo record);

    PhysicalStationInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhysicalStationInfo record);

    int updateByPrimaryKey(PhysicalStationInfo record);
}