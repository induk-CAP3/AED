package com.example.aed.controller;

public class EmerData {
    private String buildAddress;
    private String buildPlace;
    private String model;
    private String managerTel;

    // 생성자
    public EmerData(String buildAddress, String buildPlace, String model, String managerTel) {
        this.buildAddress = buildAddress;
        this.buildPlace = buildPlace;
        this.model = model;
        this.managerTel = managerTel;
    }
    public EmerData() {
        // 기본 생성자에서는 아무 작업도 하지 않습니다.
        // 필드를 초기화하지 않고 객체를 생성합니다.
    }

    public String getBuildAddress() {
        return buildAddress;
    }

    public void setBuildAddress(String buildAddress) {
        this.buildAddress = buildAddress;
    }

    public String getBuildPlace() {
        return buildPlace;
    }

    public void setBuildPlace(String buildPlace) {
        this.buildPlace = buildPlace;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManagerTel() {
        return managerTel;
    }

    public void setManagerTel(String managerTel) {
        this.managerTel = managerTel;
    }
}

