package com.aygxy.service;

import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Vehicle;
import org.springframework.data.domain.Pageable;

/**
 * @Description: 业务实现层接口
 * @Author: xmf
 * @Date: 2019/4/11-18:37
 */
public interface VehicleService {
    //添加车辆
    Result add(Vehicle vehicle);
    //删除车辆
    Result delete(String uid);
    //编辑车辆
    Result update(String uid,Vehicle vehicle);
    //分页查询测试
    Result findAll(Pageable pageable);
    //动态查询
    Result dynamicQuery(Pageable pageable,Vehicle vehicle);

}
