package com.example.wantedpreonboardingbackend.apply.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wantedpreonboardingbackend.apply.entity.ApplyEntity;
import com.example.wantedpreonboardingbackend.apply.repository.ApplyRepository;

@Service
public class ApplyService {
    @Autowired
    ApplyRepository applyRepository;

    // 채용공고에 지원
    public void create(@Valid ApplyEntity applyEntity) {
        applyRepository.save(applyEntity);
    }

    public int findByDouble(@Valid ApplyEntity applyEntity) {
        Long 채용공고_id = applyEntity.get채용공고_id();
        String 사용자_id = applyEntity.get사용자_id();
        int result = applyRepository.findbyDouble(채용공고_id, 사용자_id);
        return result;
    }
    
}
