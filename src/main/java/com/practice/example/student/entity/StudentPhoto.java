package com.practice.example.student.entity;

import com.practice.example.student.entity.Student;

import javax.persistence.*;

/**
 *
 *  학생 사진 엔티티
 */
@Entity
public class StudentPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photoId;

    private String url;


    //<---------------- 연관 관계

    @OneToOne
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    private Student student;

    //----------------> 연관 관계


}
