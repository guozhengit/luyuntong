package com.aygxy.xmf.mybatis.entity;

public class PhysicalSType {
    private String id;

    private String typeCode;

    private String typeName;

    private String typeId;

    private String typeGroupId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getTypeGroupId() {
        return typeGroupId;
    }

    public void setTypeGroupId(String typeGroupId) {
        this.typeGroupId = typeGroupId == null ? null : typeGroupId.trim();
    }
}