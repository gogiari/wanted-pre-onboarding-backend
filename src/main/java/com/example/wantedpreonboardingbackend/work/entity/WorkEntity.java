package com.example.wantedpreonboardingbackend.work.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@ToString


@Table(name = "채용등록")
public class WorkEntity {
    @Id
    @Column
    private String 회사_id;

    @Column(nullable = false)
    private String 채용포지션;

    @Column(nullable = false)
    private int 채용보상금;

    @Column(nullable = false)
    private String 채용내용;

    @Column(nullable = false)
    private String 사용기술;

    @Builder
    public WorkEntity(String 회사_id, String 채용포지션, int 채용보상금, String 채용내용, String 사용기술){
        this.회사_id = 회사_id;
        this.채용포지션 = 채용포지션;
        this.채용보상금 = 채용보상금;
        this.채용내용 = 채용내용;
        this.사용기술 = 사용기술;

    }
}
