package com.example.wantedpreonboardingbackend.work.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.wantedpreonboardingbackend.work.dto.WorkSelectDTO;
import com.example.wantedpreonboardingbackend.work.entity.WorkEntity;

public interface WorkRepository extends JpaRepository<WorkEntity, Long> {
    @Query("SELECT new com.example.wantedpreonboardingbackend.work.dto.WorkSelectDTO(e.채용공고_id, e.회사_id, e.채용포지션, e.채용보상금, e.사용기술) FROM WorkEntity e")
    List<WorkSelectDTO> findAllAsDTO();

    @Query("SELECT 채용공고_id FROM WorkEntity e WHERE e.회사_id = :회사_id")
    List<Integer> findAllBy회사_id(@Param("회사_id") String 회사_id);
}
