package com.example.studing.childrenhelper.dao;

import com.example.studing.childrenhelper.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    @Query("select s from School s join fetch s.schoolClasses sc where sc.name like %:nameSchoolClass%")
    List<School> findSchoolClasses(@Param("nameSchoolClass")String nameSchoolClass);

}
