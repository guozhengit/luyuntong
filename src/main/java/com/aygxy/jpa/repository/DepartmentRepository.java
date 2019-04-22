package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.Department;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 部门信息时间仓库
 * @Author: xmf
 * @Date: 2019/4/7-16:13
 */
@Repository
public interface DepartmentRepository extends BaseRepository<Department,String>{
    @Modifying
    @Transactional
    @Query("delete from Department s where s.id in (?1)")
    void deleteAll(List<String> ids);
}
