package com.aygxy.jpa.repository;

import com.aygxy.jpa.BaseRepository;
import com.aygxy.jpa.entity.DetailGoods;
import org.springframework.stereotype.Repository;

/**
 * @Description: 商品明细数据仓库
 * @Author: xmf
 * @Date: 2019/4/7-16:15
 */
@Repository
public interface DetailGoodsRepository extends BaseRepository<DetailGoods,String>{
}
