package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.Employee;
import org.springframework.stereotype.Repository;

/**
 * @Description: 职员信息数据仓库
 * @Author: xmf
 * @Date: 2019/4/7-16:28
 */
@Repository
public interface EmployeeRepository extends BaseRepository<Employee,String>{
}
