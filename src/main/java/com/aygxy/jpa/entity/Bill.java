package com.aygxy.jpa.entity;

import com.aygxy.jpa.BaseJpaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * @Description:
 * @Author: xmf
 * @Date: 2019/4/6-23:38
 */
@Getter
@Setter
@Entity
@Table(name = "physical_bill_info")
public class Bill extends BaseJpaEntity {
    //单据编号
    @Column(name = "bill_code",columnDefinition = "varchar(200)")
    private String code;
    //单据类型
    @Column(name = "type",columnDefinition = "varchar(200)")
    private String  type;
    //业务员
    @Column(name = "sales_man",columnDefinition = "varchar(200)")
    private String salesMan;
    //业务站点
    @Column(name = "sales_station",columnDefinition = "varchar(200)")
    private String salesStation;
    //收款类型
    @Column(name = "gather_type",columnDefinition = "varchar(200)")
    private String gatherType;
    //托运人
    @Column(name = "consign_man",columnDefinition = "varchar(200)")
    private String conSignMan;
    //托运联系电话
    @Column(name = "consign_phone",columnDefinition = "varchar(200)")
    private String conSignPhone;
    //始发地址
    @Column(name = "start_address",columnDefinition = "varchar(200)")
    private String startAddress;
    //始发所在区域
    @Column(name = "start_region",columnDefinition = "varchar(200)")
    private String startRegion;
    //始发邮编
    @Column(name = "start_post_code",columnDefinition = "varchar(200)")
    private String startPostCode;
    //始发日期
    @Column(name = "start_date",columnDefinition = "varchar(200)")
    private String startDate;
    //始发站点
    @Column(name = "start_station",columnDefinition = "varchar(200)")
    private String startStation;
    //接货人
    @Column(name = "receive_man",columnDefinition = "varchar(200)")
    private String receiveMan;
    //接货联系电话
    @Column(name = "receive_phone",columnDefinition = "varchar(200)")
    private String receivePhone;
    //接货地址
    @Column(name = "receive_address",columnDefinition = "varchar(200)")
    private String receiveAddress;
    //接货日期
    @Column(name = "receiveDate",columnDefinition = "varchar(200)")
    private String receiveDate;
    //目标站点
    @Column(name = "targetStation",columnDefinition = "varchar(200)")
    private String targetStation;
    //服务类型
    @Column(name = "serviceType",columnDefinition = "varchar(200)")
    private String serviceType;
    //运输方式
    @Column(name = "transportationType",columnDefinition = "varchar(200)")
    private String transportationType;
    //其他费用
    @Column(name = "otherCost",nullable = true, precision=12, scale=2)
    private BigDecimal otherCost;
    //物流费用
    @Column(name = "logisticsCost",nullable = true, precision=12, scale=2)
    private BigDecimal logisticsCost;
    //运输费用
    @Column(name = "transportCost",nullable = true, precision=12, scale=2)
    private BigDecimal transportCost;
    //付款类型
    @Column(name = "paymentType",columnDefinition = "varchar(200)")
    private String paymentType;
    //应付金额
    @Column(name = "accountPayable",nullable = true, precision=12, scale=2)
    private BigDecimal accountPayable;
    //实付金额
    @Column(name = "realityPayable",nullable = true, precision=12, scale=2)
    private BigDecimal realityPayable;
    //未付金额
    @Column(name = "unReceivedPayable",nullable = true, precision=12, scale=2)
    private BigDecimal unReceivedPayable;
    //折让金额
    @Column(name = "allowancePayable",nullable = true, precision=12, scale=2)
    private BigDecimal allowancePayable;
    //发车状态
    @Column(name = "ArriveVehicleStatus",columnDefinition = "varchar(200)")
    private String arriveVehicleStatus;
    //车到站状态
    @Column(name = "DepartVehicleStatus",columnDefinition = "varchar(200)")
    private String departVehicleStatus;
    //车牌号
    @Column(name = "vehicleCode",columnDefinition = "varchar(200)")
    private String vehicleCode;
    //车辆类型
    @Column(name = "vehicleType",columnDefinition = "varchar(200)")
    private String vehicleType;
    //司机姓名
    @Column(name = "driverName",columnDefinition = "varchar(200)")
    private String driverName;
    //司机电话
    @Column(name = "driverPhone",columnDefinition = "varchar(200)")
    private String driverPhone;
    //收入金额
    @Column(name = "incomePayable",nullable = true, precision=12, scale=2)
    private BigDecimal incomePayable;
    //支出金额
    @Column(name = "expendPayable",nullable = true, precision=12, scale=2)
    private BigDecimal expendPayable;
    //收支合计
    @Column(name = "paymentsTotal",nullable = true, precision=12, scale=2)
    private BigDecimal paymentsTotal;
    //收支日期
    @Column(name = "paymentsDate",columnDefinition = "varchar(200)")
    private String paymentsDate;




















    //运输单据编号
    @Column(name = "vehicleBillCode",columnDefinition = "varchar(200)")
    private String  vehicleBillCode;
    //运输单据类型
    @Column(name = "vehicelBillType",columnDefinition = "varchar(200)")
    private String  vehicelBillType;
    //运输单据开具日期
    @Column(name = "vehicleBillDate",columnDefinition = "varchar(200)")
    private String  vehicleBillDate;
    //结算单据编号
    @Column(name = "accountBillCode",columnDefinition = "varchar(200)")
    private String  accountBillCode;
    //结算单据结算
    @Column(name = "accountBillType",columnDefinition = "varchar(200)")
    private String  accountBillType;
    //结算单据结算
    @Column(name = "accountBillDate",columnDefinition = "varchar(200)")
    private String  accountBillDate;
    //收支单据结算
    @Column(name = "paymentCode",columnDefinition = "varchar(200)")
    private String  paymentCode;
    //客户姓名
    @Column(name = "customer_property",columnDefinition = "varchar(200)")
    private String customerName;
    //目标邮编
    @Column(name = "targetPostCode",columnDefinition = "varchar(200)")
    private String targetPostCode;
    //目标所在区域
    @Column(name = "targetRegion",columnDefinition = "varchar(200)")
    private String targetRegion;



    @Column(name = "customer_code",columnDefinition = "varchar(200)")
    private String customerCode;

    @Column(name = "detailGoods_customer_code",columnDefinition = "varchar(200)")
    private String detailGoodsCustomerCode;

    @Column(name = "detailPayment_customer_code",columnDefinition = "varchar(200)")
    private String detailPaymentCustomerCode;


    public Bill(String routeCode, String cityCode) {
        super();
    }

    public Bill() {
    }
}
