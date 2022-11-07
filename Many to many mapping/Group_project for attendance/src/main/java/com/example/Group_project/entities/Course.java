package com.example.Group_project.entities;

import javax.persistence.*;
import java.security.AllPermission;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COURSES")
public class Course {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO) //cid generates automatically
        private int cId;
        private String name;
        private String credits;
        private String work;
        private String email;
        private String phone;
        private String image;

        @Column(length = 1000)
        private String description;


        //many to one with user
        @ManyToOne
        private User user;//foreign key column is created

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "courses")
        private List<Module> modules = new ArrayList<>();

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "courses")
        private List<Student> students = new ArrayList<>();

         public Course() {

        }


    public Course(int cId, String name, String credits, String work, String email, String phone, String image, String description, User user, List<Module> modules, List<Student> students) {
        this.cId = cId;
        this.name = name;
        this.credits = credits;
        this.work = work;
        this.email = email;
        this.phone = phone;
        this.image = image;
        this.description = description;
        this.user = user;
        this.modules = modules;
        this.students = students;
    }

    public int getcId() {
            return cId;
        }

        public void setcId(int cId) {
            this.cId = cId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCredits() {
            return credits;
        }

        public void setCredits(String credits) {
            this.credits = credits;
        }

        public String getWork() {
            return work;
        }

        public void setWork(String work) {
            this.work = work;
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


        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public List<Module> getModules() {
             return modules;
         }

        public void setModules(List<Module> modules) {
            this.modules = modules;
        }

        public List<Student> getStudents() {
            return students;
         }
         public void setStudents(List<Student> students) {
            this.students = students;
        }

    @Override
    public String toString() {
        return "Course{" +
                "cId=" + cId +
                ", name='" + name + '\'' +
                ", secondName='" + credits + '\'' +
                ", work='" + work + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}


