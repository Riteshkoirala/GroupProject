package com.example.Group_project.REpository;

import com.example.Group_project.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModuleREpository extends JpaRepository<Module, Integer> {

    @Query("from Module as m where m.courses.cId =:courseId")
    public List<Module> findModuleByCourse(@Param("courseId") int courseId);

}
