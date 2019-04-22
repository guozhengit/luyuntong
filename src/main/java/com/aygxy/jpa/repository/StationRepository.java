package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.Station;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 站点数据仓库
 * @Author: xmf
 * @Date: 2019/4/7-16:25
 */
@Repository
public interface StationRepository extends BaseRepository<Station,String>{
    @Modifying
    @Transactional
    @Query("delete from Station s where s.id in (?1)")
    void deleteAll(List<String> ids);
}
