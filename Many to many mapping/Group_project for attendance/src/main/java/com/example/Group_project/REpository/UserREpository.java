package com.example.Group_project.REpository;
import com.example.Group_project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

    public interface UserREpository extends JpaRepository<User, Integer> {
        @Query("select u from User u where u.email= :email") // query for getting user by username
        //param email should match with email

        public User getUserByUserName(@Param("email") String email);
        //getting dynamic email

    }
