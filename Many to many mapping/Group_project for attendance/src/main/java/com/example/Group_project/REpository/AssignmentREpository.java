package com.example.Group_project.REpository;

import com.example.Group_project.entities.Assignment;
import com.example.Group_project.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssignmentREpository extends JpaRepository<Assignment, Integer> {

    @Query("from Assignment as a where a.module.mId =:moduleId")
    public List<Assignment> findAssignmentByModule(@Param("moduleId") int moduleId);

}
