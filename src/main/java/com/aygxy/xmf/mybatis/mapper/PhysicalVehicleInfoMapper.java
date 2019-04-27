package com.aygxy.xmf.mybatis.mapper;

import com.aygxy.xmf.mybatis.entity.PhysicalVehicleInfo;

public interface PhysicalVehicleInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhysicalVehicleInfo record);

    int insertSelective(PhysicalVehicleInfo record);

    PhysicalVehicleInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhysicalVehicleInfo record);

    int updateByPrimaryKey(PhysicalVehicleInfo record);
}