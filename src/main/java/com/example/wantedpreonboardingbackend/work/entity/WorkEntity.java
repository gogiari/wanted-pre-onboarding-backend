package com.example.wantedpreonboardingbackend.work.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import com.example.wantedpreonboardingbackend.work.dto.WorkUpdateDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@ToString


@Table(name = "채용공고")
public class WorkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long 채용공고_id;

    @Column(nullable = false)
    private String 회사_id;

    @Column(nullable = false)
    private String 채용포지션;

    @Column(nullable = false)
    private int 채용보상금;

    @Column(nullable = false)
    private String 채용내용;

    @Column(nullable = false)
    private String 사용기술;
    
    public void update(@Valid WorkUpdateDTO workUpdateDTO){
        if(workUpdateDTO.get회사_id() != null)
        this.회사_id = workUpdateDTO.get회사_id();
        
        if(workUpdateDTO.get채용포지션() != null)
        this.채용포지션 = workUpdateDTO.get채용포지션();

        if(workUpdateDTO.get채용보상금() != null)
        this.채용보상금 = workUpdateDTO.get채용보상금();
        
        if(workUpdateDTO.get채용내용() != null)
        this.채용내용 = workUpdateDTO.get채용내용();
        
        if(workUpdateDTO.get사용기술() != null)
        this.사용기술 = workUpdateDTO.get사용기술();
    }

    @Builder
    public WorkEntity(String 회사_id, String 채용포지션, int 채용보상금, String 채용내용, String 사용기술){
        this.회사_id = 회사_id;
        this.채용포지션 = 채용포지션;
        this.채용보상금 = 채용보상금;
        this.채용내용 = 채용내용;
        this.사용기술 = 사용기술;
    }

}
