package com.aygxy.mybatis.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PhysicalBillInfo {
    private String id;

    private Date createTime;

    private Date updateTime;

    private String accountBillCode;

    private String accountBillDate;

    private String accountBillType;

    private BigDecimal accountPayable;

    private BigDecimal allowancePayable;

    private String arriveVehicleStatus;

    private String billCode;

    private String consignMan;

    private String consignPhone;

    private String customerCode;

    private String customerProperty;

    private String departVehicleStatus;

    private String detailGoodsCustomerCode;

    private String detailPaymentCustomerCode;

    private String driverName;

    private String driverPhone;

    private BigDecimal expendPayable;

    private String gatherType;

    private BigDecimal incomePayable;

    private BigDecimal logisCost;

    private BigDecimal otherCost;

    private String paymentCode;

    private String paymentType;

    private String paymentsDate;

    private BigDecimal paymentsTotal;

    private BigDecimal realityPayable;

    private String receiveAddress;

    private String receiveDate;

    private String receiveMan;

    private String receivePhone;

    private String salesMan;

    private String salesStation;

    private String serviceType;

    private String startAddress;

    private String startDate;

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

    private String vehicelBillType;

    private String vehicleBillCode;

    private String vehicleBillDate;

    private String vehicleCode;

    private String vehicleType;

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

    public String getAccountBillCode() {
        return accountBillCode;
    }

    public void setAccountBillCode(String accountBillCode) {
        this.accountBillCode = accountBillCode == null ? null : accountBillCode.trim();
    }

    public String getAccountBillDate() {
        return accountBillDate;
    }

    public void setAccountBillDate(String accountBillDate) {
        this.accountBillDate = accountBillDate == null ? null : accountBillDate.trim();
    }

    public String getAccountBillType() {
        return accountBillType;
    }

    public void setAccountBillType(String accountBillType) {
        this.accountBillType = accountBillType == null ? null : accountBillType.trim();
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

    public String getArriveVehicleStatus() {
        return arriveVehicleStatus;
    }

    public void setArriveVehicleStatus(String arriveVehicleStatus) {
        this.arriveVehicleStatus = arriveVehicleStatus == null ? null : arriveVehicleStatus.trim();
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode == null ? null : billCode.trim();
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

    public String getDepartVehicleStatus() {
        return departVehicleStatus;
    }

    public void setDepartVehicleStatus(String departVehicleStatus) {
        this.departVehicleStatus = departVehicleStatus == null ? null : departVehicleStatus.trim();
    }

    public String getDetailGoodsCustomerCode() {
        return detailGoodsCustomerCode;
    }

    public void setDetailGoodsCustomerCode(String detailGoodsCustomerCode) {
        this.detailGoodsCustomerCode = detailGoodsCustomerCode == null ? null : detailGoodsCustomerCode.trim();
    }

    public String getDetailPaymentCustomerCode() {
        return detailPaymentCustomerCode;
    }

    public void setDetailPaymentCustomerCode(String detailPaymentCustomerCode) {
        this.detailPaymentCustomerCode = detailPaymentCustomerCode == null ? null : detailPaymentCustomerCode.trim();
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

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode == null ? null : paymentCode.trim();
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public String getPaymentsDate() {
        return paymentsDate;
    }

    public void setPaymentsDate(String paymentsDate) {
        this.paymentsDate = paymentsDate == null ? null : paymentsDate.trim();
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

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate == null ? null : receiveDate.trim();
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
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

    public String getVehicelBillType() {
        return vehicelBillType;
    }

    public void setVehicelBillType(String vehicelBillType) {
        this.vehicelBillType = vehicelBillType == null ? null : vehicelBillType.trim();
    }

    public String getVehicleBillCode() {
        return vehicleBillCode;
    }

    public void setVehicleBillCode(String vehicleBillCode) {
        this.vehicleBillCode = vehicleBillCode == null ? null : vehicleBillCode.trim();
    }

    public String getVehicleBillDate() {
        return vehicleBillDate;
    }

    public void setVehicleBillDate(String vehicleBillDate) {
        this.vehicleBillDate = vehicleBillDate == null ? null : vehicleBillDate.trim();
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
}