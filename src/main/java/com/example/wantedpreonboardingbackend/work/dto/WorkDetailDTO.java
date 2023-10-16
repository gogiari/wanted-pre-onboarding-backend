package com.example.wantedpreonboardingbackend.work.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WorkDetailDTO {
    private Long 채용공고_id;

    private String 회사_id;

    private String 채용포지션;

    private Integer 채용보상금;

    private String 채용내용;

    private String 사용기술;

    private List<Integer> 회사가올린다른채용공고;

    @Builder
    public WorkDetailDTO(String 회사_id, String 채용포지션, Integer 채용보상금, String 채용내용, String 사용기술, List<Integer> 회사가올린다른채용공고) {
        this.회사_id = 회사_id;
        this.채용포지션 = 채용포지션;
        this.채용보상금 = 채용보상금;
        this.채용내용 = 채용내용;
        this.사용기술 = 사용기술;
        this.회사가올린다른채용공고 = 회사가올린다른채용공고;
    }
}
