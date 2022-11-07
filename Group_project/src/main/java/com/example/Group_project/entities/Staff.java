package com.example.Group_project.entities;

import javax.persistence.*;

@Entity
@Table(name = "STAFFS")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int staffId;
    private String staffName;
    private String address;
    private String gender;
    private String age;
    private String email;
    private String phone;
    private String qualification;
    private String department;

    @ManyToOne
    private Module modules;

    public Staff() {
    }

    public Staff(int staffId, String staffName, String address, String gender, String age, String email, String phone, String qualification, String department, Module modules) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.qualification = qualification;
        this.department = department;
        this.modules = modules;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Module getModules() {
        return modules;
    }

    public void setModules(Module modules) {
        this.modules = modules;
    }
}

