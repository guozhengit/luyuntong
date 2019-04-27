package com.aygxy.jpa.entity;

import com.aygxy.jpa.BaseJpaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * @Description: 主单据信息实体-- 托运单、发车单、到车单、回车单、收支单、__客户结算单、__司机结算单
 * 托运单：托运单负责管理物流托运业务，支持按重量、体积和件数进行运费计算，支持现付、到付、回付和月结付款方式，支持站到站、门到站、站到门、门到门服务方式，支持查看货物发车和到车状态等等。
 * 发车单：发车单支持现付、到付、回付的填写，方便管理运输各阶段司机应收的金额；能够即时查看发车货物是否全到车、车辆是否已回车；可以对托运货物进行分车多次发车。
 * 到车单：用于管理到车业务，在其它费用明细中可以填写司机运输途中所花的餐饮费、加油费、过路费等其它费用。
 * 回车单：回车单用于记录回程中司机的整车收入和其它费用支出，如餐饮费、加油费等等，方便运输成本的核算。
 * 其它收支单：支持网点租金、水电费、电话费、差旅费等其它费用的记账。
 * __客户结算单:客户结算单负责对客户的一个或多个托运单进行收款，支持对同一托运单的分次收款。
 * __司机结算单:司机结算单负责对司机的一个或多个发车单进行收款，支持对同一发车单的分次付款。
 * @Author: xmf
 * @Date: 2019/4/6-23:38
 */
@Getter
@Setter
@Entity
@Table(name = "physical_bill_info")
public class Bill extends BaseJpaEntity {
    ////单据id
    //单据编号
    @Column(name = "bill_code",columnDefinition = "varchar(200)")
    private String code;
    //单价类型
    @Column(name = "type",columnDefinition = "varchar(200)")
    private String  type;
    //业务员
    @Column(name = "sales_man",columnDefinition = "varchar(200)")
    private String salesMan;
    //业务站点
    @Column(name = "sales_station",columnDefinition = "varchar(200)")
    private String salesStation;
    //客户姓名
    @Column(name = "customer_property",columnDefinition = "varchar(200)")
    private String customerName;
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
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
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
    @Column(name = "receiveDate")
    @Temporal(TemporalType.DATE)
    private Date receiveDate;
    //目标站点
    @Column(name = "targetStation",columnDefinition = "varchar(200)")
    private String targetStation;
    //目标邮编
    @Column(name = "targetPostCode",columnDefinition = "varchar(200)")
    private String targetPostCode;
    //目标所在区域
    @Column(name = "targetRegion",columnDefinition = "varchar(200)")
    private String targetRegion;
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
    @Column(name = "logisCost",nullable = true, precision=12, scale=2)
    private BigDecimal logisCost;
    //运输费用
    @Column(name = "transportCost",nullable = true, precision=12, scale=2)
    private BigDecimal transportCost;

    //付款类型
    @Column(name = "paymentType",nullable = true, precision=12, scale=2)
    private BigDecimal paymentType;
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
    private String ArriveVehicleStatus;
    //车到站状态
    @Column(name = "DepartVehicleStatus",columnDefinition = "varchar(200)")
    private String DepartVehicleStatus;

    //车牌号
    @Column(name = "vehicleCode",columnDefinition = "varchar(200)")
    private String vehicleCode;
    //车辆类型
    @Column(name = "vehicleType",columnDefinition = "varchar(200)")
    private String vehicleType;
    //司机姓名
    @Column(name = "driverName",columnDefinition = "varchar(200)")
    private String driverName;
    //司机姓名
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
    @Column(name = "paymentsDate")
    @Temporal(TemporalType.DATE)
    private Date paymentsDate;

    //可选属性optional=false,表示customer不能为空。删除单据，不影响客户
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="customer_code")//设置在Bill表中的关联字段(外键)
    private Customer customer;

    @OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.REMOVE},mappedBy="bill")
    private Set<DetailGoods> detailGoods;

    @OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.REMOVE},mappedBy="bill")
    private Set<DetailPayment> detailPayments;

}
