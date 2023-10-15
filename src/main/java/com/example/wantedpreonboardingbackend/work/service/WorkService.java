package com.example.wantedpreonboardingbackend.work.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wantedpreonboardingbackend.work.dto.WorkCreateDTO;
import com.example.wantedpreonboardingbackend.work.dto.WorkUpdateDTO;
import com.example.wantedpreonboardingbackend.work.entity.WorkEntity;
import com.example.wantedpreonboardingbackend.work.repository.WorkRepository;

@Service
public class WorkService {
    @Autowired
    WorkRepository workRepository;

    public List<WorkEntity> findAll() {
        List<WorkEntity> workList = workRepository.findAll();
        return workList;
    }

    public void save(@Valid WorkCreateDTO workCreateDTO) {
        System.out.println(workCreateDTO);
        WorkEntity workEntity = workCreateDTO.toEntity();
        workRepository.save(workEntity);
    }
    
    public Optional<WorkEntity> findbyId(Long 채용공고_id) {
        Optional<WorkEntity> workEntity = workRepository.findById(채용공고_id);
        return workEntity;
    }

    public void update(@Valid WorkUpdateDTO workUpdateDTO, WorkEntity workEntity) {
        // workEntity = workUpdateDTO.toEntity();
        workEntity.update(workUpdateDTO);
        System.out.println(workEntity);
        workRepository.save(workEntity);
    }
    
}
