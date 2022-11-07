package com.example.Group_project.Configuration;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import com.example.Group_project.entities.User;


    public class CustomUserDetails implements UserDetails {

        private User user;

        public CustomUserDetails(User user) {
            this.user = user;
        }

        @Override
        //returning roles of user
        public Collection<? extends GrantedAuthority> getAuthorities() {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole());
            //all role of user is returned like normal admin
            return List.of(simpleGrantedAuthority);
        }

        @Override
        public String getPassword() {
            return user.getPassword();
        }

        @Override
        public String getUsername() {
            return user.getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }


