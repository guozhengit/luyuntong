package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.City;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 城市信息数据仓库
 * @Author: xmf
 * @Date: 2019/4/7-16:32
 */
@Repository
@Transactional
public interface CityRepository extends BaseRepository<City,String>{

}
