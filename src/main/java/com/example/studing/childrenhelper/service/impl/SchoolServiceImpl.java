package com.example.studing.childrenhelper.service.impl;

import com.example.studing.childrenhelper.converter.SchoolConverter;
import com.example.studing.childrenhelper.dao.SchoolRepository;
import com.example.studing.childrenhelper.dto.SchoolDto;
import com.example.studing.childrenhelper.entity.School;
import com.example.studing.childrenhelper.service.SchoolService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolServiceImpl implements SchoolService {
    private SchoolRepository schoolRepository;
    private SchoolConverter schoolConverter;

    @Override
    public List<SchoolDto> findSchools(String schoolClassName) {
        List<School> schools =schoolRepository.findSchoolClasses(schoolClassName);
        return schoolConverter.toListDtos(schools);
    }

    @Override
    public void addSchool(SchoolDto schoolDto) {
        School school = schoolConverter.toEntity(schoolDto);
        schoolRepository.save(school);
    }
}
