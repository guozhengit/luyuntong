package com.aygxy.mybatis.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PhysicalDetilGoodsInfo {
    private String id;

    private Date createTime;

    private Date updateTime;

    private String name;

    private String billGoodsCode;

    private BigDecimal carrierCost;

    private String goodsCode;

    private BigDecimal deliverCost;

    private String high;

    private String isDangerous;

    private BigDecimal price;

    private Integer quantity;

    private BigDecimal totalPrice;

    private String type;

    private String vehicleCode;

    private String volume;

    private String weight;

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

    public String getBillGoodsCode() {
        return billGoodsCode;
    }

    public void setBillGoodsCode(String billGoodsCode) {
        this.billGoodsCode = billGoodsCode == null ? null : billGoodsCode.trim();
    }

    public BigDecimal getCarrierCost() {
        return carrierCost;
    }

    public void setCarrierCost(BigDecimal carrierCost) {
        this.carrierCost = carrierCost;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    public BigDecimal getDeliverCost() {
        return deliverCost;
    }

    public void setDeliverCost(BigDecimal deliverCost) {
        this.deliverCost = deliverCost;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high == null ? null : high.trim();
    }

    public String getIsDangerous() {
        return isDangerous;
    }

    public void setIsDangerous(String isDangerous) {
        this.isDangerous = isDangerous == null ? null : isDangerous.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode == null ? null : vehicleCode.trim();
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume == null ? null : volume.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }
}