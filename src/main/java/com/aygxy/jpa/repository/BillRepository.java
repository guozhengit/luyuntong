package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.Bill;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 主单据信息数据明细
 * @Author:
 * @Date: 2019/4/7-16:23
 */
@Repository
public interface BillRepository extends BaseRepository<Bill,String>{
    @Modifying
    @Transactional
    @Query("delete from Bill s where s.id in (?1)")
    void deleteAll(List<String> ids);
}
