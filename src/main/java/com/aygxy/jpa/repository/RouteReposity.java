package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.Route;
import org.springframework.stereotype.Repository;

/**
 * @Description: 路线信息数据仓库
 * @Author: xmf
 * @Date: 2019/4/7-16:25
 */
@Repository
public interface RouteReposity extends BaseRepository<Route,String>{
}
