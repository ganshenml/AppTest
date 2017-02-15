package com.example.administrator.apptest;

public class TestOb implements java.io.Serializable {
    private static final long serialVersionUID = 1593518903687138770L;
    private int ProvinceId;
    private int CityOrder;
    private int CityId;
    private String CityName;

    public int getProvinceId() {
        return this.ProvinceId;
    }

    public void setProvinceId(int ProvinceId) {
        this.ProvinceId = ProvinceId;
    }

    public int getCityOrder() {
        return this.CityOrder;
    }

    public void setCityOrder(int CityOrder) {
        this.CityOrder = CityOrder;
    }

    public int getCityId() {
        return this.CityId;
    }

    public void setCityId(int CityId) {
        this.CityId = CityId;
    }

    public String getCityName() {
        return this.CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

}
