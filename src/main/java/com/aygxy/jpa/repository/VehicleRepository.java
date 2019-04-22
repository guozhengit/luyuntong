package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.Vehicle;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 车辆信息数据仓库
 * @Author: xmf
 * @Date: 2019/4/7-16:26
 */
@Repository
public interface VehicleRepository extends BaseRepository<Vehicle,String>{

    @Modifying
    @Transactional
    @Query("delete from Vehicle s where s.id in (?1)")
    void deleteAll(List<String> ids);
}
