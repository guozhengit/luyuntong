    package com.aygxy.mybatis.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Description: 盈利统计请求
 * @Author: Guoyongzheng
 * @Date: 2019/5/9-1:23
 */
@Getter
@Setter
public class ProfitModel {
    //接算金额
    private BigDecimal settlementAmount;
    //未结算
    private BigDecimal outstandingAmount;
    //工资成本
    private BigDecimal payrollCost;
    //支出成本
    private BigDecimal amountPaid;
    //预计盈利
    private BigDecimal expectedProfitAmount;
    //实际盈利
    private BigDecimal actualProfitAmount;
    private String ProfitTime;
}
