package com.aygxy.service;

import com.aygxy.base.Result;
import com.aygxy.jpa.entity.DetailGoods;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description: 业务实现层接口
 * @Author: xmf
 * @Date: 2019/4/11-18:37
 */
public interface DetailGoodsService {

    //添加货物信息
    Result add(DetailGoods detailGoods);
    //删除货物信息
    Result delete(String id);
    //批量删除
    Result deleteBatch(List<String> ids);
    //编辑货物信息
    Result update(String id,DetailGoods detailGoods);
    //动态查询
    Result dynamicQuery(Pageable pageable,DetailGoods detailGoods);
}
