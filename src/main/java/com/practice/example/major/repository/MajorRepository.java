package com.practice.example.major.repository;

import com.practice.example.major.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MajorRepository extends JpaRepository<Major, Long> {

    Optional<Major> findByMajorCode(String code);
}
