package com.aygxy.jpa.entity;

import com.aygxy.jpa.BaseNamedJpaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Description: 站点信息实体
 * @Author: xmf
 * @Date: 2019/4/7-0:37
 */
@Getter
@Setter
@Entity
@Table(name = "physical_station_info")
public class Station extends BaseNamedJpaEntity {
    //站点id  //站点名称
    //站点编号
    @Column(name = "station_code",columnDefinition = "varchar(50)")
    private String code;
    //站点负责人
    @Column(name = "principal",columnDefinition = "varchar(50)")
    private String principal;
    //联系电话
    @Column(name = "link_phone",columnDefinition = "varchar(50)")
    private String linkPhone;
    //详细地址
    @Column(name = "detail_address",columnDefinition = "varchar(50)")
    private String detailAddress;
    //邮编
    @Column(name = "post_code",columnDefinition = "varchar(50)")
    private String postCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_code")
    private City city;
}
