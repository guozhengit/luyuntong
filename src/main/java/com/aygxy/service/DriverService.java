package com.aygxy.service;

import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Driver;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description: 业务实现层接口
 * @Author: xmf
 * @Date: 2019/4/11-18:37
 */
public interface DriverService {

    //添加司机信息
    Result add(Driver driver);
    //删除司机信息
    Result delete(String id);
    //批量删除
    Result deleteBatch(List<String> ids);
    //编辑司机信息
    Result update(String id,Driver driver);
    //动态查询
    Result dynamicQuery(Pageable pageable,Driver driver);
}
