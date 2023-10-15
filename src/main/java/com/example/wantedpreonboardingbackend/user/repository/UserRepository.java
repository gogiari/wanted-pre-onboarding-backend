package com.example.wantedpreonboardingbackend.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wantedpreonboardingbackend.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    
}
