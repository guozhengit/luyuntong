package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.Bill;
import org.springframework.stereotype.Repository;

/**
 * @Description: 主单据信息数据明细
 * @Author:
 * @Date: 2019/4/7-16:23
 */
@Repository
public interface BillRepository extends BaseRepository<Bill,String>{
}
