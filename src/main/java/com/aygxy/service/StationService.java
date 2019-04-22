package com.aygxy.service;

import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Station;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description: 业务实现层接口
 * @Author: xmf
 * @Date: 2019/4/11-18:37
 */
public interface StationService {
    //添加站点
    Result add(Station station);
    //删除站点
    Result delete(String id);
    //批量删除
    Result deleteBatch(List<String> ids);
    //编辑站点
    Result update(String id,Station station);
    //动态查询
    Result dynamicQuery(Pageable pageable,Station station);
}
