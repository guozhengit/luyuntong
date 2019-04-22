package com.aygxy.service;

import com.aygxy.base.Result;
import com.aygxy.jpa.entity.City;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description: 业务实现层接口
 * @Author: xmf
 * @Date: 2019/4/11-18:37
 */
public interface CityService {

    //添加城市信息
    Result add(City city);
    //删除城市信息
    Result delete(String id);
    //批量删除
    Result deleteBatch(List<String> ids);
    //编辑城市信息
    Result update(String id,City city);
    //动态查询
    Result dynamicQuery(Pageable pageable,City city);
}
