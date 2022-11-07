package com.example.withMysql.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Modules {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int mid;
    @Column(name = "module_name")
    private String moduleName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "modules")
    private List<Emp> emps = new ArrayList<>();

    public Modules() {
    }

    public Modules(int mid, String moduleName) {
        this.mid = mid;
        this.moduleName = moduleName;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
