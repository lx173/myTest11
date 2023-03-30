package com.tuling.springbootsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Auther: lxx
 * @Date: 2023/3/16 12:00
 * @Description:
 */
public class MyUserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if("admin1".equals(username)){
            return User.withUsername("admin1").password("123").authorities("mobile","salary").build();
        }
        return null;
    }
}
