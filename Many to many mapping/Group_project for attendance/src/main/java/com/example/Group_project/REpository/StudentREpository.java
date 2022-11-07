package com.example.Group_project.REpository;

import com.example.Group_project.entities.Course;
import com.example.Group_project.entities.Student;
import com.example.Group_project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface StudentREpository extends JpaRepository<Student, Integer> {

    @Query("select s from Student s where s.email=:email") // query for getting user by username
    public Student getStudentByUserName(@Param("email") String email);

//    @Query("select s from Student s where s.courses.cId=:cId")
//    public Student getStudentByCourseId(@Param("cId") Integer cId);
//
//    @Query(value = "select * from Student where courses.cId in :cid", nativeQuery = true)
//    List<Student> findStudentByCourse(@Param("cid") List<Integer> ids);
}
