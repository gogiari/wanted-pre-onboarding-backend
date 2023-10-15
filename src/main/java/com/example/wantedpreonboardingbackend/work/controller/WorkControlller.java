package com.example.wantedpreonboardingbackend.work.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wantedpreonboardingbackend.work.dto.WorkCreateDTO;
import com.example.wantedpreonboardingbackend.work.dto.WorkUpdateDTO;
import com.example.wantedpreonboardingbackend.work.entity.WorkEntity;
import com.example.wantedpreonboardingbackend.work.service.WorkService;

@RestController
public class WorkControlller {
    @Autowired
    WorkService workService;

    // 채용공고 전체 조회
    @GetMapping("/work")
    public List<WorkEntity> list() {
        List<WorkEntity> workList = workService.findAll();
        System.out.println("리스트: " + workList.toString());
        return workList;
    }

    // 채용공고 등록
    @PostMapping("/work/create")
    public ResponseEntity<?> create(@RequestBody @Valid WorkCreateDTO workCreateDTO, BindingResult bindingResult) {
        // System.out.println(workCreateDTO);
        if (bindingResult.hasErrors()) {
            List<Object> errorList = new ArrayList<>();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError fieldError = (FieldError) objectError;
                String fieldName = fieldError.getField();
                String message = objectError.getDefaultMessage();
                Map<String, String> errorMap = new HashMap<>();
                errorMap.put("field", fieldName);
                errorMap.put("message", message);
                errorList.add(errorMap);
            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
        }
        workService.save(workCreateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(workCreateDTO);
    }

    // 채용공고 수정
    @PatchMapping("/work/update/{채용공고_id}")
    public ResponseEntity<?> update(@PathVariable Long 채용공고_id, @RequestBody @Valid WorkUpdateDTO workUpdateDTO, BindingResult bindingResult) {

        // 채용공고id 기반 조회
        Optional<WorkEntity> workEntity = workService.findbyId(채용공고_id);
        if(workEntity.isEmpty()){
            return new ResponseEntity<>("채용공고_id를 확인해주세요", HttpStatus.BAD_REQUEST);
        }

        // 회사_id변경 방지
        if(workUpdateDTO.get회사_id() != null){
            return new ResponseEntity<>("회사_id는 변경불가.", HttpStatus.BAD_REQUEST);
        }
        workService.update(workUpdateDTO, workEntity.orElse(null));
        return new ResponseEntity<>(workEntity, HttpStatus.OK);
    }
}
