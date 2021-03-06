package com.example.studing.childrenhelper.converter;

import com.example.studing.childrenhelper.dto.ChildDto;
import com.example.studing.childrenhelper.entity.Child;
import com.example.studing.childrenhelper.entity.Exercise;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
public class ChildConverter extends AbstractConverter<Child, ChildDto>{
    @Override
    public Child toEntity(ChildDto childDto) {
        Child child = new Child();
        Exercise exercise = new Exercise();
        exercise.setCondition(childDto.getExerciseConditions().isEmpty() ? "" : childDto.getExerciseConditions().get(0));
        child.setFirstname(childDto.getFirstname());
        child.setLastname(childDto.getLastname());
        child.addExercise(exercise);
        return child;
    }

    @Override
    public ChildDto toDto(Child child) {
        ChildDto childDto = new ChildDto();
        childDto.setFirstname(childDto.getFirstname());
        childDto.setLastname(childDto.getLastname());
        childDto.setExerciseConditions(child.getExercises().stream().map(x->x.getCondition()).collect(Collectors.toList()));
        return childDto;
    }
}
