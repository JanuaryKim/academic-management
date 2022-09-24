package com.practice.example.major.entity;

import com.practice.example.major.entity.Major;
import com.practice.example.professor.entity.Lecture;
import com.practice.example.registration.entity.Registration;

import javax.persistence.*;
import java.util.List;

/**
 *
 *  과목 엔티티
 */
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;

    private String name;

    //<---------------- 연관 관계

    @OneToMany(mappedBy = "subject") //수강 리스트
    List<Registration> registrationList;

    @OneToMany(mappedBy = "subject") //강의 리스트
    List<Lecture> lectureList;

    @ManyToOne
    @JoinColumn(name = "MAJOR_ID", nullable = false)
    Major major;
    //----------------> 연관 관계
}
