package com.aygxy.mybatis.entity;

import java.util.Date;

public class PhysicalVehicleInfo {
    private String id;

    private Date createTime;

    private Date updateTime;

    private String name;

    private String allowCarryHigh;

    private String allowCarryVolume;

    private String allowCarryWeight;

    private String vehicleCode;

    private String vehicleGoodsCode;

    private String vehicleEngineNumber;

    private String vehicleFrameNumber;

    private String vehicleHigh;

    private String insuranceCard;

    private String vehicleLength;

    private String vehicleModel;

    private String vehicleOwner;

    private String enterpriseCode;

    private String vehicleType;

    private String useredAge;

    private String vehicleWidth;

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

    public String getAllowCarryHigh() {
        return allowCarryHigh;
    }

    public void setAllowCarryHigh(String allowCarryHigh) {
        this.allowCarryHigh = allowCarryHigh == null ? null : allowCarryHigh.trim();
    }

    public String getAllowCarryVolume() {
        return allowCarryVolume;
    }

    public void setAllowCarryVolume(String allowCarryVolume) {
        this.allowCarryVolume = allowCarryVolume == null ? null : allowCarryVolume.trim();
    }

    public String getAllowCarryWeight() {
        return allowCarryWeight;
    }

    public void setAllowCarryWeight(String allowCarryWeight) {
        this.allowCarryWeight = allowCarryWeight == null ? null : allowCarryWeight.trim();
    }

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode == null ? null : vehicleCode.trim();
    }

    public String getVehicleGoodsCode() {
        return vehicleGoodsCode;
    }

    public void setVehicleGoodsCode(String vehicleGoodsCode) {
        this.vehicleGoodsCode = vehicleGoodsCode == null ? null : vehicleGoodsCode.trim();
    }

    public String getVehicleEngineNumber() {
        return vehicleEngineNumber;
    }

    public void setVehicleEngineNumber(String vehicleEngineNumber) {
        this.vehicleEngineNumber = vehicleEngineNumber == null ? null : vehicleEngineNumber.trim();
    }

    public String getVehicleFrameNumber() {
        return vehicleFrameNumber;
    }

    public void setVehicleFrameNumber(String vehicleFrameNumber) {
        this.vehicleFrameNumber = vehicleFrameNumber == null ? null : vehicleFrameNumber.trim();
    }

    public String getVehicleHigh() {
        return vehicleHigh;
    }

    public void setVehicleHigh(String vehicleHigh) {
        this.vehicleHigh = vehicleHigh == null ? null : vehicleHigh.trim();
    }

    public String getInsuranceCard() {
        return insuranceCard;
    }

    public void setInsuranceCard(String insuranceCard) {
        this.insuranceCard = insuranceCard == null ? null : insuranceCard.trim();
    }

    public String getVehicleLength() {
        return vehicleLength;
    }

    public void setVehicleLength(String vehicleLength) {
        this.vehicleLength = vehicleLength == null ? null : vehicleLength.trim();
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel == null ? null : vehicleModel.trim();
    }

    public String getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(String vehicleOwner) {
        this.vehicleOwner = vehicleOwner == null ? null : vehicleOwner.trim();
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode == null ? null : enterpriseCode.trim();
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType == null ? null : vehicleType.trim();
    }

    public String getUseredAge() {
        return useredAge;
    }

    public void setUseredAge(String useredAge) {
        this.useredAge = useredAge == null ? null : useredAge.trim();
    }

    public String getVehicleWidth() {
        return vehicleWidth;
    }

    public void setVehicleWidth(String vehicleWidth) {
        this.vehicleWidth = vehicleWidth == null ? null : vehicleWidth.trim();
    }
}