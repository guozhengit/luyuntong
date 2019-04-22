package com.aygxy.service;

import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Route;
import com.aygxy.jpa.entity.Station;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description: 业务实现层接口
 * @Author: xmf
 * @Date: 2019/4/11-18:37
 */
public interface RouteService {

    //添加路线
    Result add(Route route);
    //删除路线
    Result delete(String id);
    //批量删除
    Result deleteBatch(List<String> ids);
    //编辑路线
    Result update(String id,Route route);
    //动态查询
    Result dynamicQuery(Pageable pageable,Route route);
}
