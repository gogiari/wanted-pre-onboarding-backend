package com.example.wantedpreonboardingbackend.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wantedpreonboardingbackend.company.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, String> {
    
}
