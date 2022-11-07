package com.example.Group_project.REpository;

import com.example.Group_project.entities.Course;
import com.example.Group_project.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseREpository extends JpaRepository<Course, Integer> {

    // implementing pagination method

    @Query("from Course as c where c.user.id =:userId")

    // It have current page: page
    // contact per page = 5
    public Page<Course> findCourseByUser(@Param("userId") int userId, Pageable perPageable);

//  @Query("from Course as c where c.user.id =:userId")
//    public List<Course> findCourseByUser1(int userId);


    @Query("from Course as c where c.cId =:cId")
    public List<Course> findCourseById(@Param("cId") int cId);

    // page :- gains position of page
}
