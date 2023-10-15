package com.example.wantedpreonboardingbackend.work.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.wantedpreonboardingbackend.work.entity.WorkEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class WorkCreateDTO {
    @NotBlank(message = "회사_id를 입력 안했거나, 공백 입니다.")
    private String 회사_id;

    @NotBlank(message = "채용포지션를 입력 안했거나, 공백 입니다.")
    private String 채용포지션;

    @NotNull(message = "채용보상금을 입력 안했거나, 공백 입니다.")
    private Integer 채용보상금;
    // private int 채용보상금;
    // primitive type인 int는 자동으로 0으로 초기화 되므로, @NotNull에 걸리지 않게 되기 때문이다.

    @NotBlank(message = "채용내용을 입력 안했거나, 공백 입니다.")
    private String 채용내용;

    @NotBlank(message = "사용기술을 입력 안했거나, 공백 입니다.")
    private String 사용기술;

    @Builder
    public WorkCreateDTO(String 회사_id, String 채용포지션, Integer 채용보상금, String 채용내용, String 사용기술) {
        this.회사_id = 회사_id;
        this.채용포지션 = 채용포지션;
        this.채용보상금 = 채용보상금;
        this.채용내용 = 채용내용;
        this.사용기술 = 사용기술;
    }

    public WorkEntity toEntity() {
        return WorkEntity.builder()
                .회사_id(회사_id)
                .채용포지션(채용포지션)
                .채용보상금(채용보상금)
                .채용내용(채용내용)
                .사용기술(사용기술)
                .build();
    }

}
