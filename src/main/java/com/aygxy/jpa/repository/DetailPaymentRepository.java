package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.DetailPayment;
import org.springframework.stereotype.Repository;

/**
 * @Description: 收支明细数据仓库
 * @Author: xmf
 * @Date: 2019/4/7-16:17
 */
@Repository
public interface DetailPaymentRepository extends BaseRepository<DetailPayment,String>{
}
