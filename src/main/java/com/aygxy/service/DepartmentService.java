package com.aygxy.service;

import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Department;
import com.aygxy.jpa.entity.DetailGoods;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description: 业务实现层接口
 * @Author: xmf
 * @Date: 2019/4/11-18:37
 */
public interface DepartmentService {

    //添加部门信息
    Result add(Department department);
    //删除部门信息
    Result delete(String id);
    //批量删除
    Result deleteBatch(List<String> ids);
    //编辑部门信息
    Result update(String id,Department department);
    //动态查询
    Result dynamicQuery(Pageable pageable,Department department);
}
