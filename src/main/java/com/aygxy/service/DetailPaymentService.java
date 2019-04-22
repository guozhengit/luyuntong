package com.aygxy.service;

import com.aygxy.base.Result;
import com.aygxy.jpa.entity.DetailPayment;
import com.aygxy.jpa.entity.Driver;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description: 业务实现层接口
 * @Author: xmf
 * @Date: 2019/4/11-18:37
 */
public interface DetailPaymentService {

    //添加收支单
    Result add(DetailPayment detailPayment);
    //删除收支单
    Result delete(String id);
    //批量删除
    Result deleteBatch(List<String> ids);
    //编辑收支单
    Result update(String id,DetailPayment detailPayment);
    //动态查询
    Result dynamicQuery(Pageable pageable,DetailPayment detailPayment);
}
