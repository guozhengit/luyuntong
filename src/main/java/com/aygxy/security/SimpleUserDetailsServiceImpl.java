package com.aygxy.security;

import com.aygxy.jpa.entity.User;
import com.aygxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;

/**
 * @author
 */
public class SimpleUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserCode(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user with id %s exists", "".equals(username) ? "null" : username));
        }
        return new SecurityUser(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getPassword(),
                true,
                false);
    }
}
