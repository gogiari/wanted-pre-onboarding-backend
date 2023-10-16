package com.example.wantedpreonboardingbackend.apply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.wantedpreonboardingbackend.apply.entity.ApplyEntity;

public interface ApplyRepository extends JpaRepository<ApplyEntity, Long> {

    @Query("SELECT COUNT(e.idx) FROM ApplyEntity e WHERE e.채용공고_id = :채용공고_id AND e.사용자_id = :사용자_id")
    int findbyDouble(@Param("채용공고_id") Long 채용공고_id, @Param("사용자_id") String 사용자_id);
    
}
