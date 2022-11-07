package com.example.withMysql.entities;

import com.example.withMysql.entities.Emp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PROJECTS")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pid;

    @Column(name="project_name")
    private String projectName;

    // we cannot used mapped by on both table with many to many relation
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private List<Emp> employees = new ArrayList<>();

//    public Project(int pid, String projectName, Emp employees) {
//        this.pid = pid;
//        this.projectName = projectName;
//        this.employees = employees;
//    }

    public Project(int pid, String projectName, List<Emp> employees) {
        this.pid = pid;
        this.projectName = projectName;
        this.employees = employees;
    }

    public Project() {
    }


    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Emp> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Emp> employees) {
        this.employees = employees;
    }


//    public Emp getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Emp employees) {
//        this.employees = employees;
//    }
}

