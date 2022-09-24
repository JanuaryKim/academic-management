package com.practice.example.professor.entity;

import com.practice.example.major.entity.Major;

import javax.persistence.*;
import java.util.List;

/**
 *
 *  교수 엔티티
 */
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long studentId;

    @Column(length = 10, nullable = false)
    String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false, unique = true)
    String securityNumber;


    //<--------------- 연관 관계

    @ManyToOne
    @JoinColumn(name = "MAJOR_ID", nullable = false)
    Major major;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    List<Lecture> lectureList;

    //----------------> 연관 관계

}
