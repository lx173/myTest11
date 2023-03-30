package com.tuling.security.distributed.salary.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Auther: lxx
 * @Date: 2023/3/18 10:42
 * @Description:
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()//打开请求认证
                .antMatchers("/salary/**")
                //.hasAuthority("salary")
                .authenticated()
                .anyRequest().permitAll();
               // .anyRequest().authenticated();
    }
}
