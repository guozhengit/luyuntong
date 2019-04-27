package com.aygxy.xmf.mybatis.mapper;

import com.aygxy.xmf.mybatis.entity.PhysicalAuthorityInfo;

public interface PhysicalAuthorityInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhysicalAuthorityInfo record);

    int insertSelective(PhysicalAuthorityInfo record);

    PhysicalAuthorityInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhysicalAuthorityInfo record);

    int updateByPrimaryKey(PhysicalAuthorityInfo record);
}