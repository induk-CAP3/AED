package com.example.aed.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "aed")
@Data
@Entity
public class AedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
//    @Column(length = 100, nullable = false)
    private String buildAddress;
//    @Column(length = 100, nullable = false)
    private String buildPlace;
//    @Column(length = 100, nullable = false)
    private String model;
//    @Column(length = 20, nullable = false)
    private String manager;
    private String managerTel;
//    @Column(length = 20, nullable = false)
    private String latitude;
//    @Column(length = 20, nullable = false)
    private String longitude;
//    @Column(length = 20, nullable = false)
    private String zip1;
//    @Column(length = 20, nullable = false)
    private String zip2;
//    @Column(length = 20, nullable = false)
    private String clienttel;
//    @Column(length = 100, nullable = false)
    private String col;
//    @Column(length = 100, nullable = false)
    private String org;

}
