package com.aygxy.xmf.mybatis.entity;

public class PhysicalSTypegroup {
    private String id;

    private String typeGroupCode;

    private String typeGroupName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTypeGroupCode() {
        return typeGroupCode;
    }

    public void setTypeGroupCode(String typeGroupCode) {
        this.typeGroupCode = typeGroupCode == null ? null : typeGroupCode.trim();
    }

    public String getTypeGroupName() {
        return typeGroupName;
    }

    public void setTypeGroupName(String typeGroupName) {
        this.typeGroupName = typeGroupName == null ? null : typeGroupName.trim();
    }
}