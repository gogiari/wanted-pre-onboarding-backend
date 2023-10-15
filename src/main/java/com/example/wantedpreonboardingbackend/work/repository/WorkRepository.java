package com.example.wantedpreonboardingbackend.work.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wantedpreonboardingbackend.work.entity.WorkEntity;

public interface WorkRepository extends JpaRepository<WorkEntity, Long> {
    
}
