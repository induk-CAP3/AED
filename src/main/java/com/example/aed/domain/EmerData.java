package com.example.aed.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmerData {
    private String buildAddress; // 응급실 주소
    private String enm; // 응급실 이름
    private String telNumber; // 응급실 번호
    private String estate; // 운영 여부
    private String latitude; // 응급실 위도
    private String longitude; // 응급실 경도
}

