package com.practice.example.student.repository;

import com.practice.example.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT s FROM Student s WHERE s.securityNumber = :securityNum")
    Optional<Student> findBySecurityNumber(String securityNum);
}
