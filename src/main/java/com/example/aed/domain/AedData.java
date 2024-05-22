package com.example.aed.domain;

import lombok.Data;

@Data
public class AedData {
    private String buildAddress; // 설치주소
    private String buildPlace; // 설치장소
    private String model; //모델명
    private String managerTel; //관리자 번호
    private String latitude; // 위도
    private String longitude; // 경도
    private String zip1; // 우편번호1
    private String zip2; // 우편번호2
    private String manager; // 관리자 이름
    private String clientTel; // 설치기관 전화번화
    private String col; // 제조사
    private String org; // 설치기관 명

}

