package com.aygxy.mybatis.entity;

import java.util.Date;

public class PhysicalRouteInfo {
    private String id;

    private Date createTime;

    private Date updateTime;

    private String cityCode;

    private String cityDistance;

    private String routeCode;

    private String routeName;

    private String startCity;

    private String startStation;

    private String stationDistance;

    private String targetCity;

    private String targetStation;

    private String transferCity;

    private String transferStation;

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

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getCityDistance() {
        return cityDistance;
    }

    public void setCityDistance(String cityDistance) {
        this.cityDistance = cityDistance == null ? null : cityDistance.trim();
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode == null ? null : routeCode.trim();
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName == null ? null : routeName.trim();
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity == null ? null : startCity.trim();
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation == null ? null : startStation.trim();
    }

    public String getStationDistance() {
        return stationDistance;
    }

    public void setStationDistance(String stationDistance) {
        this.stationDistance = stationDistance == null ? null : stationDistance.trim();
    }

    public String getTargetCity() {
        return targetCity;
    }

    public void setTargetCity(String targetCity) {
        this.targetCity = targetCity == null ? null : targetCity.trim();
    }

    public String getTargetStation() {
        return targetStation;
    }

    public void setTargetStation(String targetStation) {
        this.targetStation = targetStation == null ? null : targetStation.trim();
    }

    public String getTransferCity() {
        return transferCity;
    }

    public void setTransferCity(String transferCity) {
        this.transferCity = transferCity == null ? null : transferCity.trim();
    }

    public String getTransferStation() {
        return transferStation;
    }

    public void setTransferStation(String transferStation) {
        this.transferStation = transferStation == null ? null : transferStation.trim();
    }
}