package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.Authority;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 权限数据仓库
 * @Author: xmf
 * @Date: 2019/4/8-23:37
 */
public interface AuthorityRepository extends BaseRepository<Authority,String>{
    @Modifying
    @Transactional
    @Query("delete from Authority s where s.id in (?1)")
    void deleteAll(List<String> ids);
}
