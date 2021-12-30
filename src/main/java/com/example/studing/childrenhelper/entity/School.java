package com.example.studing.childrenhelper.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schoolGen")
    @Column(name = "id")
    private Long id;
    @Column(name = "school_name")
    private String name;
    private String city;
    private String street;
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private Set<SchoolClass> schoolClasses = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Set<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    private void setSchoolClasses(Set<SchoolClass> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }
    public void addSchoolClasses(SchoolClass schoolClass){
        schoolClasses.add(schoolClass);
    }
    public boolean removeSchoolClass(SchoolClass schoolClass){
        return schoolClasses.remove(schoolClass);
    }
}
