package com.example.withMysql.controller;

import com.example.withMysql.dao.ProjectRepository;
import com.example.withMysql.entities.Emp;
import com.example.withMysql.dao.EmployeeRepository;
import com.example.withMysql.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        Emp emp = new Emp();
        emp.setName("Durgesh");
        employeeRepository.save(emp);
        return "Working";
    }

    @GetMapping("/test1")
    @ResponseBody
    public String test1(){
        Emp emp = new Emp();
        int cid = 12;
        Project project = new Project();
        List<Emp> emps = new ArrayList<>();

        emp.setName("Alpha1 beta1");
        project.setEmployees(emps);

        employeeRepository.save(emp);
        projectRepository.save(project);

        return "Working";
    }


}
