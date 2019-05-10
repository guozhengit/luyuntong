package com.aygxy.mybatis.entity;

import java.util.Date;

public class PhysicalCityInfo {
    private String id;

    private Date createTime;

    private Date updateTime;

    private String name;

    private String cityCode;

    private String district;

    private String location;

    private String ownerProvince;

    private String routeCode;

    private String stationsCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getOwnerProvince() {
        return ownerProvince;
    }

    public void setOwnerProvince(String ownerProvince) {
        this.ownerProvince = ownerProvince == null ? null : ownerProvince.trim();
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode == null ? null : routeCode.trim();
    }

    public String getStationsCode() {
        return stationsCode;
    }

    public void setStationsCode(String stationsCode) {
        this.stationsCode = stationsCode == null ? null : stationsCode.trim();
    }
}