package com.aygxy.jpa.entity;

import com.aygxy.jpa.BaseNamedJpaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 顾客信息实体
 * @Author: xmf
 * @Date: 2019/4/7-0:53
 */
@Getter
@Setter
@Entity
@Table(name = "physical_customer_info")
public class Customer extends BaseNamedJpaEntity {

    //客户id //客户姓名
    //客户编号
    @Column(name = "customer_code",columnDefinition = "varchar(200)")
    private String code;

    @Column(name = "detail_address",columnDefinition = "varchar(200)")
    //详细地址
    private String detailAddress;

    @Column(name = "past_code",columnDefinition = "varchar(200)")
    //邮编
    private String postCode;

    @Column(name = "link_mobile",columnDefinition = "varchar(200)")
    //联系电话
    private String linkMobile;

    @Column(name = "type",columnDefinition = "varchar(200)")
    //客户类型
    private String type;

    @Column(name = "enterprise_property",columnDefinition = "varchar(200)")
    //企业性质
    private String enterpriseProperty;

    @Column(name = "enterprise_size",columnDefinition = "varchar(200)")
    //企业规模
    private String enterpriseSize;

    @Column(name = "email",columnDefinition = "varchar(200)")
    //电子邮箱
    private String eMail;

    @Column(name = "customer_bill_code",columnDefinition = "varchar(200)")
    private String customerBillCode;

    //映射单向一对多的关联关系
    //使用@OneToMany 来映射一对多的关联关系
    //使用@JoinColumn 来映射外键列的名称
    //可以使用@OneToMany的fetch 属性来修改默认的加载策略
    //可以通过@OneToMany的cascade 属性来修改默认的删除策略
    //cascade={CascadeType.REMOVE} 会把主表和从表的数据都删除
    //mappedBy表明放弃关联关系维护并且不能再使用
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    //private Set<Bill> bills = new HashSet<>();


}
