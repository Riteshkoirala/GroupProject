package com.example.Group_project.Configuration;

import com.example.Group_project.REpository.UserREpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.Group_project.entities.User;

    public class UserDetailsServiceImpl implements UserDetailsService {
        @Autowired
        private UserREpository userREpository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            //get user from database

            User user= userREpository.getUserByUserName(username);

            if (user== null){
                throw new UsernameNotFoundException("could not found user");
            }
            CustomUserDetails customUserDetails = new CustomUserDetails(user);
            return customUserDetails;
        }
    }


