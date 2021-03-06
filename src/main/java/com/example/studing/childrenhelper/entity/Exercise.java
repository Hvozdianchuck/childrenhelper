package com.example.studing.childrenhelper.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exerciseGen")
    @Column(name = "id")
    private Long id;
    private String condition;
    @ManyToMany(mappedBy = "exercises", cascade = CascadeType.ALL)
    private Set<Child> children = new HashSet<>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
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
