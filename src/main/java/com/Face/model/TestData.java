package com.Face.model;

import java.util.Date;

public class TestData {

    private String id;

    private String userId;

    private String typeName;

    private double firstProportion;

    private double secondProportion;

    private double thirdProportion;

    private String picUrl;

    private Date createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId(){ return  userId; }

    public void setUserId(String userId){ this.userId = userId; }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public double getFirstProportion() {
        return firstProportion;
    }

    public void setFirstProportion(double firstProportion) {
        this.firstProportion = firstProportion;
    }

    public double getSecondProportion() {
        return secondProportion;
    }

    public void setSecondProportion(double secondProportion) {
        this.secondProportion = secondProportion;
    }

    public double getThirdProportion() {
        return thirdProportion;
    }

    public void setThirdProportion(double thirdProportion) {
        this.thirdProportion = thirdProportion;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
