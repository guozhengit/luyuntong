package com.aygxy.jpa.entity;

import com.aygxy.jpa.BaseNamedJpaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 运输车辆实体类
 * @Author: xmf
 * @Date: 2019/4/6-15:26
 */
@Setter
@Getter
@Entity
@Table(name = "physical_vehicle_info")
public class Vehicle extends BaseNamedJpaEntity {
    //车辆id
    //车牌号
    @Column(name = "vehicle_code",columnDefinition = "varchar(50)")
    private String code;
    //车辆所属人
    @Column(name = "vehicle_owner",columnDefinition = "varchar(50)")
    private String owner;
    //站点编号 --StationEntity
    @Column(name = "enterprise_code",columnDefinition = "varchar(50)")
    private String stationCode;
    //车辆类型
    @Column(name = "vehicle_type",columnDefinition = "varchar(50)")
    private String  type;
    //车辆型号
    @Column(name = "vehicle_model",columnDefinition = "varchar(50)")
    private String  model;
    //车身长度
    @Column(name = "vehicle_length",columnDefinition = "varchar(50)")
    private String  length;
    //车身高度
    @Column(name = "vehicle_high",columnDefinition = "varchar(50)")
    private String  high;
    //车身宽度
    @Column(name = "vehicle_width",columnDefinition = "varchar(50)")
    private String  width;
    //车辆准载体积
    @Column(name = "allow_carry_volume",columnDefinition = "varchar(50)")
    private String allowCarryVolume;
    //车辆准载重量
    @Column(name = "allow_carry_weight",columnDefinition = "varchar(50)")
    private String allowCarryWeight;
    //测量准载高度
    @Column(name = "allow_carry_high",columnDefinition = "varchar(50)")
    private String allowCarryHigh;
    //车辆使用年限
    @Column(name = "usered_age",columnDefinition = "varchar(50)")
    private String useAge;
    //车辆车架编号
    @Column(name = "vehicle_frame_number",columnDefinition = "varchar(50)")
    private String frameNo;
    //车辆发动机型号
    @Column(name = "vehicle_engine_number",columnDefinition = "varchar(50)")
    private String engineNo;
    //保险卡号
    @Column(name = "insurance_card",columnDefinition = "varchar(50)")
    private String insuranceCard;

    // JoinTable所在的一端为多方关系的维护端
    // 指定当前表在中间表的外键名称和外键所指向的当前表主键
    // 指定另一方在中间表的外键名称和外键所指向的主键
    @ManyToMany
    @JoinTable(name = "vehicle_goods_info", joinColumns= {@JoinColumn(name = "vehicle_code")}, inverseJoinColumns= {@JoinColumn(name = "goods_code")})
    private Set<DetailGoods> detailGoodsSet = new HashSet<>();
}
