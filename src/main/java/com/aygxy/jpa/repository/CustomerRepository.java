package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.Customer;
import org.springframework.stereotype.Repository;

/**
 * @Description: 客户数据仓库
 * @Author: xmf
 * @Date: 2019/4/7-16:11
 */
@Repository
public interface CustomerRepository extends BaseRepository<Customer,String>{

}
