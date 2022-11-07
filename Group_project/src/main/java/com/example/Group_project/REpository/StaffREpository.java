package com.example.Group_project.REpository;

import com.example.Group_project.entities.Course;
import com.example.Group_project.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffREpository extends JpaRepository<Staff, Integer> {

    @Query("select s from Staff s where s.email=:email") // query for getting staff by username
    public Staff getStaffByUserName(@Param("email") String email);


}
