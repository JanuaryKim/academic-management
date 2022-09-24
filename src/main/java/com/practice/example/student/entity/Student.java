package com.practice.example.student.entity;


import com.practice.example.major.entity.Major;
import com.practice.example.registration.entity.Registration;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


/**
 *
 *  학생 엔티티
 */
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Student { //Entity 의 필드 조건은 DB 필드를 생각하여 설정

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long memberId;

    @Column(length = 10, nullable = false)
    String name;

    @Column(nullable = false, length = 20)
    StudentStatus studentStatus = StudentStatus.ATTENDING;

    @Column(nullable = false)
    Integer grade;

    @Column(nullable = false, unique = true)
    String securityNumber;


    //<---------------- 연관 관계

    @ManyToOne
    @JoinColumn(name = "MAJOR_ID", nullable = false)
    Major major;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    Reward reward;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    StudentPhoto studentPhoto;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    List<Registration> registrationList;


    //----------------> 연관 관계

    @Getter
    public enum StudentStatus {
        ATTENDING("재학 중"),
        GRADUATE("졸업"),
        TAKE_SEMESTER_OFF("휴학");

        String korName;

        StudentStatus(String korName)
        {
            this.korName = korName;
        }

    }
}
