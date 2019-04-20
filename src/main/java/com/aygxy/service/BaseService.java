package com.aygxy.service;

import com.aygxy.base.Result;

/**
 * @Description: 业务层基类
 * @Author: Guoyongzheng
 * @Date: 2019/4/13-2:09
 */
public interface BaseService {

    //添加
    Result add(Object var);
    //删除
    Result delete(String var);
    //编辑
    Result update(String var1,Object var2);
}
