package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 职员信息数据仓库
 * @Author: xmf
 * @Date: 2019/4/7-16:28
 */
@Repository
public interface EmployeeRepository extends BaseRepository<Employee,String>{
    @Modifying
    @Transactional
    @Query("delete from Employee s where s.id in (?1)")
    void deleteAll(List<String> ids);
}
