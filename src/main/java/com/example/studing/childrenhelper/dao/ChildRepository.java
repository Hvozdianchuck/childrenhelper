package com.example.studing.childrenhelper.dao;

import com.example.studing.childrenhelper.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
    @Query("select c from Child c join fetch c.exercises ex where ex.name like %:name%")
    List<Child> findChildren(@Param("name") String exerciseName);
}
