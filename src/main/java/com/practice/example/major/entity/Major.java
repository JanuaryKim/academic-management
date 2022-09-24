package com.practice.example.major.entity;

import com.practice.example.professor.entity.Professor;
import com.practice.example.student.entity.Student;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 *
 *  전공 엔티티
 */
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long majorId;

    @Column(length = 10, nullable = false)
    private String majorName;

    @Column(length = 3, nullable = false, unique = true)
    private String majorCode;


    //<--------------- 연관 관계

    @OneToMany(mappedBy = "major")
    List<Student> studentList;

    @OneToMany(mappedBy = "major")
    List<Professor> professorList;

    @OneToMany(mappedBy = "major")
    List<Subject> subjectList;

    //----------------> 연관 관계
}
