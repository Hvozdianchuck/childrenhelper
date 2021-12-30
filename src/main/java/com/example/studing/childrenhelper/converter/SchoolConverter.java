package com.example.studing.childrenhelper.converter;

import com.example.studing.childrenhelper.dto.SchoolDto;
import com.example.studing.childrenhelper.entity.School;
import com.example.studing.childrenhelper.entity.SchoolClass;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
public class SchoolConverter extends AbstractConverter<School, SchoolDto>{
    @Override
    public School toEntity(SchoolDto schoolDto) {
        School school = new School();
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setName(schoolDto.getName());
        school.setCity(schoolDto.getCity());
        school.setName(schoolDto.getName());
        school.setStreet(schoolDto.getStreet());
        school.addSchoolClasses(schoolClass);
        return school;
    }

    @Override
    public SchoolDto toDto(School school) {
        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setCity(school.getCity());
        schoolDto.setName(school.getName());
        schoolDto.setStreet(school.getStreet());
        schoolDto.setSchoolClasses(school.getSchoolClasses().stream().map(x->x.getName()).collect(Collectors.toList()));
        return schoolDto;
    }
}
