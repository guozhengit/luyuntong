package com.aygxy.jpa.entity;

import com.aygxy.jpa.BaseNamedJpaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 货物信息表实体
 * @Author: xmf
 * @Date: 2019/4/6-23:20
 */
@Getter
@Setter
@Entity
@Table(name = "physical_detil_goods_info")
public class DetailGoods extends BaseNamedJpaEntity {
    //货物id  //货物名称
    @Column(name = "goods_code",columnDefinition = "varchar(200)")
    private  String code;
    //货物类型
    @Column(name = "type",columnDefinition = "varchar(200)")
    private String type;
    //TODO：货物单件运费 = 运费算法(重点)
    @Column(name = "price",nullable = true, precision=12, scale=2)
    private BigDecimal price;
    //取货费
    @Column(name = "carrier_cost",nullable = true, precision=12, scale=2)
    private BigDecimal carrierCost;
    //送货费
    @Column(name = "deliver_cost",nullable = true, precision=12, scale=2)
    private BigDecimal deliverCost;
    //TODO：货物总运费 = 单价运费*数量 + 取货费 + 送货费
    @Column(name = "total_price",nullable = true, precision=12, scale=2)
    private BigDecimal totalPrice;
    //货物数量
    @Column(name = "quantity")
    private Integer quantity;
    //货物体积
    @Column(name = "volume",columnDefinition = "varchar(200)")
    private String volume;
    //货物高度
    @Column(name = "high",columnDefinition = "varchar(200)")
    private String high;
    //货物重量
    @Column(name = "weight",columnDefinition = "varchar(200)")
    private String weight;
    //是否为危险物
    @Column(name = "is_dangerous",columnDefinition = "varchar(200)")
    private String isDangerous;
    //
    @Column(name = "bill_goods_code",columnDefinition = "varchar(200)")
    private String billGoodsCode;

    @Column(name = "vehicle_code",columnDefinition = "varchar(200)")
    private String vehicleCode;

}
