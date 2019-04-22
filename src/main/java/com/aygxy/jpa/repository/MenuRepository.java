package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.Menu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 菜单信息数据明细
 * @Author: Guoyongzheng
 * @Date: 2019/4/7-16:24
 */
@Repository
public interface MenuRepository extends BaseRepository<Menu,String>{
    @Modifying
    @Transactional
    @Query("delete from Menu s where s.id in (?1)")
    void deleteAll(List<String> ids);
}
