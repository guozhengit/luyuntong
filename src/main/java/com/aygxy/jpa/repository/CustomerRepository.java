package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 客户数据仓库
 * @Author: xmf
 * @Date: 2019/4/7-16:11
 */
@Repository
public interface CustomerRepository extends BaseRepository<Customer,String>{
    @Modifying
    @Transactional
    @Query("delete from Customer s where s.id in (?1)")
    void deleteAll(List<String> ids);

}
