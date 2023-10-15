package com.example.wantedpreonboardingbackend.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "사용자")
public class UserEntity {
    @Id
    @Column(length = 40)
    private String 사용자_id;
}
