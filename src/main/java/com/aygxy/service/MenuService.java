package com.aygxy.service;

import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Menu;
import com.aygxy.jpa.entity.Route;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description: 业务实现层接口
 * @Author: xmf
 * @Date: 2019/4/11-18:37
 */
public interface MenuService {
    //添加目录
    Result add(Menu menu);
    //删除目录
    Result delete(String id);
    //批量删除
    Result deleteBatch(List<String> ids);
    //编辑目录
    Result update(String id,Menu menu);
    //动态查询
    Result dynamicQuery(Pageable pageable,Menu menu);
}
