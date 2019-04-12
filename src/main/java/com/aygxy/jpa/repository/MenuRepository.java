package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.Menu;
import org.springframework.stereotype.Repository;

/**
 * @Description: 菜单信息数据明细
 * @Author: Guoyongzheng
 * @Date: 2019/4/7-16:24
 */
@Repository
public interface MenuRepository extends BaseRepository<Menu,String>{
}
