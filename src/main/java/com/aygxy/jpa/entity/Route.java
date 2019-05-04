package com.aygxy.jpa.entity;

import com.aygxy.jpa.BaseJpaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 路线实体对象
 * @Author: xmf
 * @Date: 2019/4/7-9:34
 */
@Setter
@Getter
@Entity
@Table(name = "physical_route_info")
public class Route extends BaseJpaEntity {
    //路线id
    //路线编号
    @Column(name = "route_code",columnDefinition = "varchar(200)")
    private String code;

     @Column(name = "route_name",columnDefinition = "varchar(200)")
    private String routeName;

    //始发城市
    @Column(name = "start_city",columnDefinition = "varchar(200)")
    private String startCity;
    //目的城市
    @Column(name = "target_city",columnDefinition = "varchar(200)")
    private String targetCity;
    //始发站点
    @Column(name = "start_station",columnDefinition = "varchar(200)")
    private String startStation;
    //目标站点
    @Column(name = "target_station",columnDefinition = "varchar(200)")
    private String targetStation;
    //城市距离
    @Column(name = "city_distance",columnDefinition = "varchar(200)")
    private String cityDistance;
    //站点距离
    @Column(name = "station_distance",columnDefinition = "varchar(200)")
    private String stationDistance;
    //中转城市
    @Column(name = "transfer_city",columnDefinition = "varchar(200)")
    private String transferCity;
    //中转站点
    @Column(name = "transfer_station",columnDefinition = "varchar(200)")
    private String transferStation;

    @ManyToMany
    @JoinTable(name="route_city_info", joinColumns=@JoinColumn(name="route_code"), inverseJoinColumns=@JoinColumn(name="city_code"))
    private Set<City> citySet = new HashSet<>();

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Route{");
        sb.append("code='").append(code).append('\'');
        sb.append(", startCity='").append(startCity).append('\'');
        sb.append(", targetCity='").append(targetCity).append('\'');
        sb.append(", startStation='").append(startStation).append('\'');
        sb.append(", targetStation='").append(targetStation).append('\'');
        sb.append(", cityDistance='").append(cityDistance).append('\'');
        sb.append(", stationDistance='").append(stationDistance).append('\'');
        sb.append(", transferCity='").append(transferCity).append('\'');
        sb.append(", transferStation='").append(transferStation).append('\'');
        sb.append(", citySet=").append(citySet);
        sb.append('}');
        return sb.toString();
    }
}
