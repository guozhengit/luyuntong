package com.aygxy.jpa.repository;

import com.aygxy.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description: user实体数据查询
 * @Author: xmf
 * @Date: 2019/4/7-12:53
 */
@Repository
public interface UserRepository extends JpaRepository<User,String>{

}
