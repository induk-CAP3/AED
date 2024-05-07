package com.example.aed.controller;

import com.example.aed.entity.AedEntity;
import com.example.aed.repository.AedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/aed")
public class DbController {

    @Autowired
    private AedRepository aedRepository;

    // 모든 AED 데이터를 가져오는 API
    @GetMapping
    public List<AedEntity> getAllAeds() {
        List<AedEntity> aeds = aedRepository.findAll();
//        System.out.println(aeds);
        return (aeds);
    }

    // AED ID로 특정 AED 데이터를 가져오는 API
//    @GetMapping("/{id}")
//    public ResponseEntity<AedEntity> getAedById(@PathVariable Long id) {
//        AedEntity aed = aedRepository.findById(id)
//                .orElse(null); // ID에 해당하는 AED가 없을 경우 null 반환
//        if (aed != null) {
//            return ResponseEntity.ok().body(aed);
//        } else {
//            return ResponseEntity.notFound().build(); // ID에 해당하는 AED가 없을 경우 404 응답 반환
//        }
//    }
}
