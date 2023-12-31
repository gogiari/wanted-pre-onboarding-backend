package com.example.wantedpreonboardingbackend.work.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WorkSelectDTO {
    private Long 채용공고_id;

    private String 회사_id;

    private String 채용포지션;

    private Integer 채용보상금;
    
    private String 사용기술;

}
