package com.aygxy.mybatis.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Description: 客户结算响应
 * @Author: Guoyongzheng
 * @Date: 2019/5/9-1:16
 */
@Getter
@Setter
public class CustomerModel {

    private String customerName;

    private String customerCode;

    private String accountType;

    private String accountStatus;

    private BigDecimal accountAmount;

    private BigDecimal unAccountAmount;

    private String accountTime;
}
