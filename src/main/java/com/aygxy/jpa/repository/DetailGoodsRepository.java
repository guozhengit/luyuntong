package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.DetailGoods;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 商品明细数据仓库
 * @Author: xmf
 * @Date: 2019/4/7-16:15
 */
@Repository
public interface DetailGoodsRepository extends BaseRepository<DetailGoods,String>{
    @Modifying
    @Transactional
    @Query("delete from DetailGoods s where s.id in (?1)")
    void deleteAll(List<String> ids);
}
