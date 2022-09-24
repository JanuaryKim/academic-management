package com.practice.example.registration.entity;

import com.practice.example.student.entity.Student;
import com.practice.example.major.entity.Subject;

import javax.persistence.*;

/**
 *
 *  수강 엔티티
 */
@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;


    //<---------------- 연관 관계

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    Student student;


    @ManyToOne
    @JoinColumn(name = "SUBJECT_ID", nullable = false)
    Subject subject;

    //----------------> 연관 관계
}
