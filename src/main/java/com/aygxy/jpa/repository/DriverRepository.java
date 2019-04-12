package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.Driver;
import org.springframework.stereotype.Repository;

/**
 * @Description: 司机信息数据仓库
 * @Author: xmf
 * @Date: 2019/4/7-16:20
 */
@Repository
public interface DriverRepository extends BaseRepository<Driver,String>{
}
