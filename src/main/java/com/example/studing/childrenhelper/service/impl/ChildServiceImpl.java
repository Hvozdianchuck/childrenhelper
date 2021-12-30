package com.example.studing.childrenhelper.service.impl;

import com.example.studing.childrenhelper.converter.ChildConverter;
import com.example.studing.childrenhelper.dao.ChildRepository;
import com.example.studing.childrenhelper.dto.ChildDto;
import com.example.studing.childrenhelper.entity.Child;
import com.example.studing.childrenhelper.service.ChildService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChildServiceImpl implements ChildService {
    private ChildRepository childRepository;
    private ChildConverter childConverter;

    public ChildServiceImpl(ChildRepository childRepository, ChildConverter childConverter) {
        this.childRepository = childRepository;
        this.childConverter = childConverter;
    }

    @Override
    public List<ChildDto> findChildren(String exerciseName) {
        List<Child> children = childRepository.findChildren(exerciseName);
        return childConverter.toListDtos(children);
    }

    @Override
    public void addChild(ChildDto childDto) {
        Child child = childConverter.toEntity(childDto);
        childRepository.save(child);
    }
}
