package com.example.studing.childrenhelper.service;

import com.example.studing.childrenhelper.dto.ChildDto;
import com.example.studing.childrenhelper.entity.Child;

import java.util.List;

public interface ChildService {
List<ChildDto> findChildren(String exerciseName);
void addChild(ChildDto childDto);
}
