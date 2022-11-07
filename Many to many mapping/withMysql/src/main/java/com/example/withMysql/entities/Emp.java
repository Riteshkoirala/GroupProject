package com.example.withMysql.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPLOYEES")
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eid;
    private String name;

    // cascage all to automatically save project if employee is saved
//    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy = "employees")
    // mappedBy means use employee of project table to map do not create new link table

//    @JoinTable(name = "emp_learn", joinColumns = {@JoinColumn(name = "eid")}, inverseJoinColumns = {@JoinColumn(name = "pid")}) // for changing name of join table
    // those who use mappedBy is join column
    // changing name of join column and inverseJoin column

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name ="emp_roles", joinColumns = @JoinColumn (name="emp_id"), inverseJoinColumns = @JoinColumn (name="project_id"))

    private List<Project> projects = new ArrayList<>();

    // one employee assign to many module. one module assign to one employee
    // one to many relation

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Modules modules;
    public Emp() {
    }


    public Emp(int eid, String name, List<Project> projects, Modules modules) {
        this.eid = eid;
        this.name = name;
        this.projects = projects;
        this.modules = modules;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Modules getModules() {
        return modules;
    }

    public void setModules(Modules modules) {
        this.modules = modules;
    }
}
