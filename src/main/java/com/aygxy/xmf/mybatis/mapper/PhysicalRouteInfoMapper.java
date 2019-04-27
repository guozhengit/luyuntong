package com.aygxy.xmf.mybatis.mapper;

import com.aygxy.xmf.mybatis.entity.PhysicalRouteInfo;

public interface PhysicalRouteInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhysicalRouteInfo record);

    int insertSelective(PhysicalRouteInfo record);

    PhysicalRouteInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhysicalRouteInfo record);

    int updateByPrimaryKey(PhysicalRouteInfo record);
}