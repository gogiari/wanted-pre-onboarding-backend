package com.example.wantedpreonboardingbackend.apply.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.wantedpreonboardingbackend.apply.entity.ApplyEntity;
import com.example.wantedpreonboardingbackend.apply.service.ApplyService;
import com.example.wantedpreonboardingbackend.work.entity.WorkEntity;
import com.example.wantedpreonboardingbackend.work.service.WorkService;

@Controller
public class ApplyController {
    @Autowired
    ApplyService applyService;
    @Autowired
    WorkService workService;

    //채용공고에 지원
    @PostMapping("/apply/create")
    public ResponseEntity<?> create(@RequestBody @Valid ApplyEntity applyEntity, BindingResult bindingResult){

        // 필드를 다 안적었을때나 공백 에러(NotBlank)
        if(bindingResult.hasErrors()){
            List<Object> errorList = new ArrayList<>();
            bindingResult.getAllErrors().forEach(e -> {
                FieldError fieldError = (FieldError) e;
                String fieldName = fieldError.getField();
                String msg = e.getDefaultMessage();
                Map<String, String> map = new HashMap<>();
                map.put("field", fieldName);
                map.put("message", msg);
                errorList.add(map);
            });
            return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
        }

        // 채용공고가 존재하지 않을때 처리
        Optional<WorkEntity> workEntity = workService.findbyId(applyEntity.get채용공고_id());
        if(workEntity.isEmpty()){
            return new ResponseEntity<>("존재하지 않는 채용공고 입니다.", HttpStatus.BAD_REQUEST);
        }

        // 1회만 지원 가능 처리
        int result = applyService.findByDouble(applyEntity);
        if(result > 0){
            return new ResponseEntity<>("이미 지원한 공고 입니다.", HttpStatus.BAD_REQUEST);
        }

        applyService.create(applyEntity);
        return new ResponseEntity<>(applyEntity, HttpStatus.OK);
    }
}
