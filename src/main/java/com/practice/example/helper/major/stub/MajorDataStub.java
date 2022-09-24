package com.practice.example.helper.major.stub;

import com.practice.example.major.entity.Major;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class MajorDataStub {

    public static List<Major> list = new ArrayList<>();

    static{

        Major major1 = Major.builder().majorId(1L).majorCode("CPS").majorName("Computer Science").build();
        Major major2 = Major.builder().majorId(2L).majorCode("JDO").majorName("Judo Science").build();

        list.add(major1);
        list.add(major2);
    }

    public static Major getMajor(Long id) {
        int index = (int)(id-1);
        return list.get(index);
    }

    public static List<Major> getMajors() {
        return list;
    }

    public static Page<Major> getMajorPage() {

        Page<Major> pageImpl = new PageImpl<>(List.of(getMajor(1L), getMajor(2L)),
                PageRequest.of(0, 10, Sort.by("majorId").descending()),
                2);

        return pageImpl;
    }
}
