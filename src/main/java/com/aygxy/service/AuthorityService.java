package com.aygxy.service;

import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Authority;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description: 业务实现层接口
 * @Author: xmf
 * @Date: 2019/4/11-18:37
 */
public interface AuthorityService {

    //添加权限信息
    Result add(Authority authority);
    //删除权限信息
    Result delete(String id);
    //批量删除
    Result deleteBatch(List<String> ids);
    //编辑权限信息
    Result update(String id,Authority authority);
    //动态查询
    Result dynamicQuery(Pageable pageable,Authority authority);
}
