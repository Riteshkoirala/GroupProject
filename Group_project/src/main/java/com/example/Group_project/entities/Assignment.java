package com.example.Group_project.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ASSIGNMENTS")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int aId;
    private String title;

    private String startDate;

    private String endDate;

    private String category;
    private String description;

    @ManyToOne
    private Module module;

    public Assignment() {
    }

    public Assignment(int aId, String title, String startDate, String endDate, String category, String description, Module module) {
        this.aId = aId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.description = description;
        this.module = module;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
