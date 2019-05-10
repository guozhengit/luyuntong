package com.aygxy.mybatis.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Description: TODO
 * @Author: Guoyongzheng
 * @Date: 2019/5/9-0:49
 */
@Getter
@Setter
public class SalaryMode {
    private String officeCode;
    private String balanceDate;
    private String idType;
    private BigDecimal salary;
    private BigDecimal bonus;
    private BigDecimal subsidy;
    private BigDecimal totalSalary;
}
