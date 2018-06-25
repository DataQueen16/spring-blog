package com.codeup.blog.services;

import com.codeup.blog.models.User;
import com.codeup.blog.models.UserWithRoles;
import com.codeup.blog.repositories.Users;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsLoader implements UserDetailsService {

    private final Users users;

    public UserDetailsLoader(Users users) {
        this.users = users;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = users.findByUsername(s);
        if(user == null) {
            throw new UsernameNotFoundException("Couldn't find user with username: " + s);
        }
        return new UserWithRoles(user);
    }
}
