package com.aygxy.service;

import com.aygxy.base.Result;
import com.aygxy.jpa.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * @Description: 用户服务类
 * @Author: Guoyongzheng
 * @Date: 2019/4/8-0:12
 */
public interface UserService  extends BaseService{

    //添加或修改用户
    Result addByOne(User userEntity);
    //删除用户
    Result deleteByOne(String uid);
    //查询用户
    Result queryById(String uid);
    //编辑用户
    Result update(String uid, User user);
    //分页查询
    Result findAll(Pageable pageable);
    //动态查询
    Result dynamicQuery(Pageable pageable,User user);

    Result deleteBatch(List<String> ids);

    User findByUserCode(String username);
}
