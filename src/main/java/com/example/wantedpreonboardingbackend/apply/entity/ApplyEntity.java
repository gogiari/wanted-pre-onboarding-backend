package com.example.wantedpreonboardingbackend.apply.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor

@Table(name = "지원")
public class ApplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    @NotNull(message = "채용공고_id를 입력 안했습니다.")
    private Long 채용공고_id;

    @Column(nullable = false)
    @NotBlank(message = "사용자_id를 입력 안했거나, 공백 입니다.")
    private String 사용자_id;
}
