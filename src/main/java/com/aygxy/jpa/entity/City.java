package com.aygxy.jpa.entity;

import com.aygxy.jpa.BaseNamedJpaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 城市实体类
 * @Author: xmf
 * @Date: 2019/4/6-23:13
 */
@Getter
@Setter
@Entity
@Table(name = "physical_city_info")
public class City extends BaseNamedJpaEntity {
    //城市id //城市名称
    //城市编号
    @Column(name = "city_code",columnDefinition = "varchar(100)")
    private String code;
    //城市位置
    @Column(name = "location",columnDefinition = "varchar(50)")
    private String location;
    //区域
    @Column(name = "district",columnDefinition = "varchar(50)")
    private String district;
    //所属省份
    @Column(name = "owner_province",columnDefinition = "varchar(50)")
    private String ownerProvince;

    @OneToMany(cascade={CascadeType.REMOVE},mappedBy="city")
    private Set<Station> stations;

    @ManyToMany(mappedBy = "citySet" )
    private Set<Route> routeSet = new HashSet<>();

}
