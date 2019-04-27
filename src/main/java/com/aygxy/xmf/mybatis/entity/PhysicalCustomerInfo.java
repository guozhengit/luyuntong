package com.aygxy.xmf.mybatis.entity;

import java.util.Date;

public class PhysicalCustomerInfo {
    private String id;

    private Date createTime;

    private Date updateTime;

    private String name;

    private String code;

    private String detailAddress;

    private String email;

    private String enterpriseProperty;

    private String enterpriseSize;

    private String linkMobile;

    private String pastCode;

    private String type;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getEnterpriseProperty() {
        return enterpriseProperty;
    }

    public void setEnterpriseProperty(String enterpriseProperty) {
        this.enterpriseProperty = enterpriseProperty == null ? null : enterpriseProperty.trim();
    }

    public String getEnterpriseSize() {
        return enterpriseSize;
    }

    public void setEnterpriseSize(String enterpriseSize) {
        this.enterpriseSize = enterpriseSize == null ? null : enterpriseSize.trim();
    }

    public String getLinkMobile() {
        return linkMobile;
    }

    public void setLinkMobile(String linkMobile) {
        this.linkMobile = linkMobile == null ? null : linkMobile.trim();
    }

    public String getPastCode() {
        return pastCode;
    }

    public void setPastCode(String pastCode) {
        this.pastCode = pastCode == null ? null : pastCode.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}