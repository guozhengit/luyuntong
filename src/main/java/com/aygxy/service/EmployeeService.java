package com.aygxy.service;

import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Employee;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description: 业务实现层接口
 * @Author: xmf
 * @Date: 2019/4/11-18:37
 */
public interface EmployeeService {

    //添加职员信息
    Result add(Employee employee);
    //删除职员信息
    Result delete(String id);
    //批量删除
    Result deleteBatch(List<String> ids);
    //编辑职员信息
    Result update(String id,Employee employee);
    //动态查询
    Result dynamicQuery(Pageable pageable,Employee employee);

}
