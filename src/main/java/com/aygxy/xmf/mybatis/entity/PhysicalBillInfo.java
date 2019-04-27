package com.aygxy.xmf.mybatis.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PhysicalBillInfo {
    private String id;

    private Date createTime;

    private Date updateTime;

    private String arriveVehicleStatus;

    private String departVehicleStatus;

    private BigDecimal accountPayable;

    private BigDecimal allowancePayable;

    private String code;

    private String consignMan;

    private String consignPhone;

    private String customerCode;

    private String customerProperty;

    private String driverName;

    private String driverPhone;

    private BigDecimal expendPayable;

    private String gatherType;

    private BigDecimal incomePayable;

    private BigDecimal logisCost;

    private BigDecimal otherCost;

    private BigDecimal paymentType;

    private Date paymentsDate;

    private BigDecimal paymentsTotal;

    private BigDecimal realityPayable;

    private String receiveAddress;

    private Date receiveDate;

    private String receiveMan;

    private String receivePhone;

    private String salesMan;

    private String salesStation;

    private String serviceType;

    private String startAddress;

    private Date startDate;

    private String startPostCode;

    private String startRegion;

    private String startStation;

    private String targetPostCode;

    private String targetRegion;

    private String targetStation;

    private BigDecimal transportCost;

    private String transportationType;

    private String type;

    private BigDecimal unReceivedPayable;

    private String vehicleCode;

    private String vehicleType;

    private String customerId;

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

    public String getArriveVehicleStatus() {
        return arriveVehicleStatus;
    }

    public void setArriveVehicleStatus(String arriveVehicleStatus) {
        this.arriveVehicleStatus = arriveVehicleStatus == null ? null : arriveVehicleStatus.trim();
    }

    public String getDepartVehicleStatus() {
        return departVehicleStatus;
    }

    public void setDepartVehicleStatus(String departVehicleStatus) {
        this.departVehicleStatus = departVehicleStatus == null ? null : departVehicleStatus.trim();
    }

    public BigDecimal getAccountPayable() {
        return accountPayable;
    }

    public void setAccountPayable(BigDecimal accountPayable) {
        this.accountPayable = accountPayable;
    }

    public BigDecimal getAllowancePayable() {
        return allowancePayable;
    }

    public void setAllowancePayable(BigDecimal allowancePayable) {
        this.allowancePayable = allowancePayable;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getConsignMan() {
        return consignMan;
    }

    public void setConsignMan(String consignMan) {
        this.consignMan = consignMan == null ? null : consignMan.trim();
    }

    public String getConsignPhone() {
        return consignPhone;
    }

    public void setConsignPhone(String consignPhone) {
        this.consignPhone = consignPhone == null ? null : consignPhone.trim();
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode == null ? null : customerCode.trim();
    }

    public String getCustomerProperty() {
        return customerProperty;
    }

    public void setCustomerProperty(String customerProperty) {
        this.customerProperty = customerProperty == null ? null : customerProperty.trim();
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName == null ? null : driverName.trim();
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone == null ? null : driverPhone.trim();
    }

    public BigDecimal getExpendPayable() {
        return expendPayable;
    }

    public void setExpendPayable(BigDecimal expendPayable) {
        this.expendPayable = expendPayable;
    }

    public String getGatherType() {
        return gatherType;
    }

    public void setGatherType(String gatherType) {
        this.gatherType = gatherType == null ? null : gatherType.trim();
    }

    public BigDecimal getIncomePayable() {
        return incomePayable;
    }

    public void setIncomePayable(BigDecimal incomePayable) {
        this.incomePayable = incomePayable;
    }

    public BigDecimal getLogisCost() {
        return logisCost;
    }

    public void setLogisCost(BigDecimal logisCost) {
        this.logisCost = logisCost;
    }

    public BigDecimal getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(BigDecimal otherCost) {
        this.otherCost = otherCost;
    }

    public BigDecimal getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(BigDecimal paymentType) {
        this.paymentType = paymentType;
    }

    public Date getPaymentsDate() {
        return paymentsDate;
    }

    public void setPaymentsDate(Date paymentsDate) {
        this.paymentsDate = paymentsDate;
    }

    public BigDecimal getPaymentsTotal() {
        return paymentsTotal;
    }

    public void setPaymentsTotal(BigDecimal paymentsTotal) {
        this.paymentsTotal = paymentsTotal;
    }

    public BigDecimal getRealityPayable() {
        return realityPayable;
    }

    public void setRealityPayable(BigDecimal realityPayable) {
        this.realityPayable = realityPayable;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress == null ? null : receiveAddress.trim();
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getReceiveMan() {
        return receiveMan;
    }

    public void setReceiveMan(String receiveMan) {
        this.receiveMan = receiveMan == null ? null : receiveMan.trim();
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone == null ? null : receivePhone.trim();
    }

    public String getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(String salesMan) {
        this.salesMan = salesMan == null ? null : salesMan.trim();
    }

    public String getSalesStation() {
        return salesStation;
    }

    public void setSalesStation(String salesStation) {
        this.salesStation = salesStation == null ? null : salesStation.trim();
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress == null ? null : startAddress.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStartPostCode() {
        return startPostCode;
    }

    public void setStartPostCode(String startPostCode) {
        this.startPostCode = startPostCode == null ? null : startPostCode.trim();
    }

    public String getStartRegion() {
        return startRegion;
    }

    public void setStartRegion(String startRegion) {
        this.startRegion = startRegion == null ? null : startRegion.trim();
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation == null ? null : startStation.trim();
    }

    public String getTargetPostCode() {
        return targetPostCode;
    }

    public void setTargetPostCode(String targetPostCode) {
        this.targetPostCode = targetPostCode == null ? null : targetPostCode.trim();
    }

    public String getTargetRegion() {
        return targetRegion;
    }

    public void setTargetRegion(String targetRegion) {
        this.targetRegion = targetRegion == null ? null : targetRegion.trim();
    }

    public String getTargetStation() {
        return targetStation;
    }

    public void setTargetStation(String targetStation) {
        this.targetStation = targetStation == null ? null : targetStation.trim();
    }

    public BigDecimal getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(BigDecimal transportCost) {
        this.transportCost = transportCost;
    }

    public String getTransportationType() {
        return transportationType;
    }

    public void setTransportationType(String transportationType) {
        this.transportationType = transportationType == null ? null : transportationType.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public BigDecimal getUnReceivedPayable() {
        return unReceivedPayable;
    }

    public void setUnReceivedPayable(BigDecimal unReceivedPayable) {
        this.unReceivedPayable = unReceivedPayable;
    }

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode == null ? null : vehicleCode.trim();
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType == null ? null : vehicleType.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }
}