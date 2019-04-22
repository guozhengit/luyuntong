package com.aygxy.service;

import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Bill;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description: 业务实现层接口
 * @Author: xmf
 * @Date: 2019/4/11-18:37
 */
public interface BillService {

    //添加单据信息
    Result add(Bill bill);
    //删除单据信息
    Result delete(String id);
    //批量删除
    Result deleteBatch(List<String> ids);
    //编辑单据信息
    Result update(String id,Bill bill);
    //动态查询
    Result dynamicQuery(Pageable pageable,Bill bill);
}
