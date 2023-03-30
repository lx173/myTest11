package com.tuling.springbootsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: lxx
 * @Date: 2023/3/16 10:43
 * @Description:
 * 注入免密解析器PasswordEncoder和用户来源UserDetailsService
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    //默认Url根路径跳转到/login，此url为spring security提供
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login");
    }

    /**
     * 自行注入一个PasswordEncoder。密码加密方式的选择
     *
     * @return
     */
    @Bean
    public PasswordEncoder getPassWordEncoder(){
        return new BCryptPasswordEncoder(10);
        // return NoOpPasswordEncoder.getInstance(); //不加密的方式
    }

    /**
     * 自行注入一个UserDetailsService
     * 如果没有的话，在UserDetailsServiceAutoConfiguration中会默认注入一个包含
     * user用户的InMemoryUserDetailsManager
     * 另外也可以采用修改configure(AuthenticationManagerBuilder auth)方法并注入
     * authenticationManagerBean的方式。
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager(
                User.withUsername("admin").password(getPassWordEncoder().encode("admin")).authorities("mobile","salary").build(),
                User.withUsername("manager").password(getPassWordEncoder().encode("manager")).authorities("mobile").build(),
                User.withUsername("worker").password(getPassWordEncoder().encode("worker")).authorities("Role_salary").build());
       return userDetailsManager;
// return new JdbcUserDetailsManager(DataSource dataSource);
        //return new MyUserService();
    }

}
