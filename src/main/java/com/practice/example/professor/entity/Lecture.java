package com.practice.example.professor.entity;

import com.practice.example.major.entity.Subject;

import javax.persistence.*;


/**
 *
 *  강의 엔티티
 */

@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lectureId;

    //<---------------- 연관 관계

    @ManyToOne
    @JoinColumn(name = "SUBJECT_ID", nullable = false)
    Subject subject;

    @ManyToOne
    @JoinColumn(name = "PROFESSOR_ID", nullable = false)
    Professor professor;

    //----------------> 연관 관계
}
