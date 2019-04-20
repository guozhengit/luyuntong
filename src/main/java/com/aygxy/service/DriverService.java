package com.aygxy.service;

import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Driver;
import org.springframework.data.domain.Pageable;

/**
 * @Description: 业务实现层接口
 * @Author: xmf
 * @Date: 2019/4/11-18:37
 */
public interface DriverService {

    Driver addDriver(Driver driver);

    Result deleteByUid(String uid);
}
