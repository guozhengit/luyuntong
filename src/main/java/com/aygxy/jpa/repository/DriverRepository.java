package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.Driver;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 司机信息数据仓库
 * @Author: xmf
 * @Date: 2019/4/7-16:20
 */
@Repository
public interface DriverRepository extends BaseRepository<Driver,String>{
    @Modifying
    @Transactional
    @Query("delete from Driver s where s.id in (?1)")
    void deleteAll(List<String> ids);
}
