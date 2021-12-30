package com.example.studing.childrenhelper.service;

import com.example.studing.childrenhelper.dto.SchoolDto;
import com.example.studing.childrenhelper.entity.School;

import java.util.List;

public interface SchoolService {
    List<SchoolDto> findSchools(String schoolClassName);
    void addSchool(SchoolDto schoolDto);
}
