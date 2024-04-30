package com.example.aed.repository;

import com.example.aed.entity.AedEntity;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface AedRepository extends JpaRepository<AedEntity, Long> {
//    Optional<AedEntity> findByCol(String col);
}
