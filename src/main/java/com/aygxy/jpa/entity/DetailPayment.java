package com.aygxy.jpa.entity;

import com.aygxy.jpa.BaseJpaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Description: 收支明细表实体
 * @Author: xmf
 * @Date: 2019/4/7-2:31
 */
@Getter
@Setter
@Entity
@Table(name = "physical_detil_payment_info")
public class DetailPayment extends BaseJpaEntity {
    //收支明细id
    //部门编号
    @Column(name = "payment_code",columnDefinition = "varchar(100)")
    private String code;
    //费用类型
    @Column(name = "fee_type",columnDefinition = "varchar(200)")
    private String feeType;
    //收支状态
    @Column(name = "status",columnDefinition = "varchar(200)")
    private String status;
    //金额
    @Column(name = "amount",nullable = true, precision=12, scale=2)
    private BigDecimal amount;
    //数量
    @Column(name = "quantity")
    private Integer quantity;
    //单位
    @Column(name = "unit",columnDefinition = "varchar(200)")
    private String unit;
    //总计
    @Column(name = "total_amount",nullable = true, precision=12, scale=2)
    private BigDecimal totalAmount;

    //单据收支ID
    @Column(name = "bill_payment_code",columnDefinition = "varchar(200)")
    private String billPaymentCode;

}
