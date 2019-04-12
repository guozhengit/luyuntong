package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.Department;
import org.springframework.stereotype.Repository;

/**
 * @Description: 部门信息时间仓库
 * @Author: xmf
 * @Date: 2019/4/7-16:13
 */
@Repository
public interface DepartmentRepository extends BaseRepository<Department,String>{
}
