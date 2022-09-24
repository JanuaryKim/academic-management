package com.practice.example.student.entity;

import com.practice.example.student.entity.Student;

import javax.persistence.*;

/**
 *
 *  상벌점 엔티티
 */
@Entity
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rewardId;

    @Column(nullable = false)
    private Integer point;

    //<---------------- 연관 관계

    @OneToOne
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    Student student;

    //----------------> 연관 관계
}
