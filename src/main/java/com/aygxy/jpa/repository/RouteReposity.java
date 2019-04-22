package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.Route;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 路线信息数据仓库
 * @Author: xmf
 * @Date: 2019/4/7-16:25
 */
@Repository
public interface RouteReposity extends BaseRepository<Route,String>{
    @Modifying
    @Transactional
    @Query("delete from Route s where s.id in (?1)")
    void deleteAll(List<String> ids);
}
