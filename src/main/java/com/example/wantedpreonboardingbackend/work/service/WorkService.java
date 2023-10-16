package com.example.wantedpreonboardingbackend.work.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wantedpreonboardingbackend.work.dto.WorkCreateDTO;
import com.example.wantedpreonboardingbackend.work.dto.WorkSelectDTO;
import com.example.wantedpreonboardingbackend.work.dto.WorkUpdateDTO;
import com.example.wantedpreonboardingbackend.work.entity.WorkEntity;
import com.example.wantedpreonboardingbackend.work.repository.WorkRepository;

@Service
public class WorkService {
    @Autowired
    WorkRepository workRepository;

    // 전체조회
    public List<WorkSelectDTO> findAll() {
        List<WorkSelectDTO> workList = workRepository.findAllAsDTO();
        return workList;
    }

    // 채용공고 등록
    public void save(@Valid WorkCreateDTO workCreateDTO) {
        System.out.println(workCreateDTO);
        WorkEntity workEntity = workCreateDTO.toEntity();
        workRepository.save(workEntity);
    }
    
    // id기반 조회
    public Optional<WorkEntity> findbyId(Long 채용공고_id) {
        Optional<WorkEntity> workEntity = workRepository.findById(채용공고_id);
        return workEntity;
    }

    // 채용공고 수정
    public void update(@Valid WorkUpdateDTO workUpdateDTO, WorkEntity workEntity) {
        // workEntity = workUpdateDTO.toEntity();
        workEntity.update(workUpdateDTO);
        System.out.println(workEntity);
        workRepository.save(workEntity);
    }

    // 채용공고 삭제
    public void delete(Long 채용공고_id) {
        workRepository.deleteById(채용공고_id);
    }

    // 채용공고 검색
    public List<WorkSelectDTO> search(String search) {
        List<WorkSelectDTO> findAll = workRepository.findAllAsDTO();
        List<WorkSelectDTO> result = new ArrayList<>();
        findAll.forEach(e -> {
            String margeString = e.get회사_id() + " " + e.get채용포지션() + " " + e.get사용기술() + " " + e.get채용보상금();
            // System.out.println(margeString);
            if(margeString.toUpperCase().contains(search.toUpperCase())){
                System.out.println(e);
                result.add(e);
            }
        });
        // System.out.println("=============================");
        // System.out.println(result);
        return result;
    }


    // 채용공고 상세 페이지
    public List<Integer> findbyIdDetail(String 회사_id) {
        List<Integer> result = workRepository.findAllBy회사_id(회사_id);
        return result;
    }
    
}
