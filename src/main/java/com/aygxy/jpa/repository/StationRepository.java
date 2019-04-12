package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.Station;
import org.springframework.stereotype.Repository;

/**
 * @Description: 站点数据仓库
 * @Author: xmf
 * @Date: 2019/4/7-16:25
 */
@Repository
public interface StationRepository extends BaseRepository<Station,String>{
}
