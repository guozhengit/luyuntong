package com.aygxy.mybatis.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Description: 结算单据响应
 * @Author: Guoyongzheng
 * @Date: 2019/5/9-1:10
 */
@Getter
@Setter
public class OperationModel {
    private String quarter;
    private String month;
    private BigDecimal rent;
    private BigDecimal waterFee;
    private BigDecimal telephoneFee;
    private BigDecimal electricFee;
    private BigDecimal totalFee;
}
