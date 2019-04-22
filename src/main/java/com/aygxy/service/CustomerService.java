package com.aygxy.service;

import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Customer;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description: 业务实现层接口
 * @Author: xmf
 * @Date: 2019/4/11-18:37
 */
public interface CustomerService {

    //添加顾客信息
    Result add(Customer customer);
    //删除顾客信息
    Result delete(String id);
    //批量删除
    Result deleteBatch(List<String> ids);
    //编辑顾客信息
    Result update(String id,Customer customer);
    //动态查询
    Result dynamicQuery(Pageable pageable,Customer customer);
}
