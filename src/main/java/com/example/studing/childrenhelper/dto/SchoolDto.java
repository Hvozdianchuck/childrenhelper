package com.example.studing.childrenhelper.dto;

import java.util.ArrayList;
import java.util.List;

public class SchoolDto {
    private String name="";
    private String city="";
    private String street="";
    private List<String> schoolClasses = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public List<String> getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(List<String> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }
}
