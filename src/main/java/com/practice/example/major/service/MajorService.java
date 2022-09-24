package com.practice.example.major.service;


import com.practice.example.exception.BusinessLogicException;
import com.practice.example.exception.ExceptionCode;
import com.practice.example.major.entity.Major;
import com.practice.example.major.repository.MajorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class MajorService {

    private final MajorRepository repository;


    public Major createMajor(Major major) {

        return verifyMajor(major);
    }

    public Major updateMajor(Major major) {

        return null;
    }





    private Major findMajor(long majorId) {
        return null;
    }

    private Page<Major> findMajor() {

        return null;
    }


    private Major ExistsMajor(long majorId) { // 존재하지 않으면 에러

        Optional<Major> findMajor = repository.findById(majorId);

        return null;
    }


    private Major verifyMajor(Major major) { // 존재하면 에러

        Optional<Major> findMajor = repository.findByMajorCode(major.getMajorCode());


        if(findMajor.isPresent())
            throw new BusinessLogicException(ExceptionCode.MAJOR_EXISTS);


        return repository.save(major);
    }

}
