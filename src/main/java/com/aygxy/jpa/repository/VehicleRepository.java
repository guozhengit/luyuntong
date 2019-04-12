package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.Vehicle;
import org.springframework.stereotype.Repository;

/**
 * @Description: 车辆信息数据仓库
 * @Author: xmf
 * @Date: 2019/4/7-16:26
 */
@Repository
public interface VehicleRepository extends BaseRepository<Vehicle,String>{
}
