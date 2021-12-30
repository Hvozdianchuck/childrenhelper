package com.example.studing.childrenhelper.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exerciseGen")
    @Column(name = "id")
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "exercises", cascade = CascadeType.ALL)
    private Set<Child> children = new HashSet<>();
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

    public Set<Child> getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(id, exercise.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private void setChildren(Set<Child> children) {
        this.children = children;
    }
    public void addChild(Child child){
        children.add(child);
    }
    public boolean removeChild(Child child){
      return children.remove(child);
    }
}
