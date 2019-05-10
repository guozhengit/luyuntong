package com.aygxy.mybatis.entity;

import java.util.Date;

public class PhysicalAuthorityInfo {
    private String id;

    private Date createTime;

    private Date updateTime;

    private String name;

    private String authorityMenuCode;

    private String authorityUserCode;

    private String authorityCode;

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

    public String getAuthorityMenuCode() {
        return authorityMenuCode;
    }

    public void setAuthorityMenuCode(String authorityMenuCode) {
        this.authorityMenuCode = authorityMenuCode == null ? null : authorityMenuCode.trim();
    }

    public String getAuthorityUserCode() {
        return authorityUserCode;
    }

    public void setAuthorityUserCode(String authorityUserCode) {
        this.authorityUserCode = authorityUserCode == null ? null : authorityUserCode.trim();
    }

    public String getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(String authorityCode) {
        this.authorityCode = authorityCode == null ? null : authorityCode.trim();
    }
}