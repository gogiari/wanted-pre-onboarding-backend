package com.example.wantedpreonboardingbackend.work.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wantedpreonboardingbackend.work.dto.WorkCreateDTO;
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
    
}
