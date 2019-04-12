package com.aygxy.service.impl;

import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Vehicle;
import com.aygxy.service.VehicleService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Description: 业务实现层接口
 * @Author: xmf
 * @Date: 2019/4/11-18:37
 */
@Service
public class VehicleServiceimpl implements VehicleService {

    @Override
    public Result add(Vehicle vehicle) {
        return null;
    }

    @Override
    public Result delete(String uid) {
        return null;
    }

    @Override
    public Result update(String uid, Vehicle vehicle) {
        return null;
    }

    @Override
    public Result findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Result dynamicQuery(Pageable pageable, Vehicle vehicle) {
        return null;
    }
}
