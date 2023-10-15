package com.example.wantedpreonboardingbackend.company.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "회사")
public class CompanyEntity {
    @Id
    @Column(length = 40)
    private String 회사_id;
}
