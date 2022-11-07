package com.example.Group_project.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.security.AlgorithmConstraints;

@Entity
@Table(name = "USER") //CHANGING NAME TO USER
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)//atuomatically increase id
        private int id;

        @NotBlank(message = "Name field is required!! ")
        @Size(min = 2, max = 20, message = "min 2 and max 20 character allowed")
        private String name;

        @Column(unique = true)// making email as unique
        private String email;
        private String password;
        private String role;
        private boolean enabled;
        private String imageUrl;


        @Column(length = 400) // specifying length of about to 500 character
        private String about;

        //Mapping user and contact relation
       @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user") //user related information
        //if user is saved contact is saved  automatically
        //fetch type lazy
        //mappedBy = "User"  do not create seperate table for foreign and primary key management like user_contact

        private List<Course> courses = new ArrayList<>();
        //creates new arraylist of contacts
        public User() {

        }



        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getAbout() {
            return about;
        }

        public void setAbout(String about) {
            this.about = about;
        }

//

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

//    @Override
//        public String toString() {
//            return "User{" +
//                    "id=" + id +
//                    ", name='" + name + '\'' +
//                    ", email='" + email + '\'' +
//                    ", password='" + password + '\'' +
//                    ", role='" + role + '\'' +
//                    ", enabled=" + enabled +
//                    ", imageUrl='" + imageUrl + '\'' +
//                    ", about='" + about + '\'' +
////                    ", contacts=" + contacts +
//                    '}';
//        }

//        public void setContacts(List<Contact> contacts) {
//            this.contacts = contacts;
//        }
//    }

}
