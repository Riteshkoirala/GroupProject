package com.example.Group_project.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MODULES")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int mId;
    private String moduleName;
    private String credits;
    private String mCode;
    private String mDuration;
    @Column(length = 100)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Course courses;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "modules")
    private List<Staff> staff;

    public Module() {
    }

    public Module(int mId, String moduleName, String credits, String mCode, String mDuration, String description, Course courses) {
        this.mId = mId;
        this.moduleName = moduleName;
        this.credits = credits;
        this.mCode = mCode;
        this.mDuration = mDuration;
        this.description = description;
        this.courses = courses;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    public String getmDuration() {
        return mDuration;
    }

    public void setmDuration(String mDuration) {
        this.mDuration = mDuration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourses() {
        return courses;
    }

    public void setCourses(Course courses) {
        this.courses = courses;
    }
}