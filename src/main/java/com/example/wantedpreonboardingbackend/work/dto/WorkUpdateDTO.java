package com.example.wantedpreonboardingbackend.work.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class WorkUpdateDTO {
    private String 회사_id;

    private String 채용포지션;

    private Integer 채용보상금;

    private String 채용내용;

    private String 사용기술;
}
