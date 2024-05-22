package com.example.aed.repository;

import com.example.aed.entity.AedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AedRepository extends JpaRepository<AedEntity, Long> {
}
