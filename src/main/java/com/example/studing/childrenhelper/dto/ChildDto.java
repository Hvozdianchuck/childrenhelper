package com.example.studing.childrenhelper.dto;

import java.util.ArrayList;
import java.util.List;

public class ChildDto {
    private String firstname="";
    private String lastname="";
    private List<String> exerciseConditions = new ArrayList<>();

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<String> getExerciseConditions() {
        return exerciseConditions;
    }

    public void setExerciseConditions(List<String> exerciseConditions) {
        this.exerciseConditions = exerciseConditions;
    }
}
