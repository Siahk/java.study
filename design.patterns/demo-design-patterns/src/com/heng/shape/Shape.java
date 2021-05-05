package com.heng.shape;

public class Shape {
    private Integer mType;
    public Shape() {};
    public Shape(Integer i) {
        this.mType = i;
    }
    public void setMType(Integer i) {
        this.mType = i;
    }
    public Integer getMType(){
        return this.mType;
    }
}
