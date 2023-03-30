package com.tuling.springbootsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Auther: lxx
 * @Date: 2023/3/16 11:12
 * @Description:
 * 注入一个自定义的配置
 */
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter { //安全适配器

    @Autowired
    private UserDetailsService userDetailsService;

    //配置安全拦截策略
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //链式配置拦截策略
        http.csrf().disable()   //关闭csrf跨域检查   否则post put 等需要token
                .authorizeRequests()  //打开请求认证
                .antMatchers("/**.html","css/**","img/**","js/**").permitAll()  //放行
                .antMatchers("/mobile/**").hasAuthority("mobile") //配置资源
                .antMatchers("/salary/**").hasAuthority("salary")
                //.antMatchers("/salary/**").hasRole("salary")
                .antMatchers("/common/**").permitAll() //common下的请求直接通 过
                .anyRequest().authenticated() //其他请求需要登录
                .and() //并行条件
                //.rememberMe().rememberMeParameter("isRemeber_me").userDetailsService(userDetailsService)
                // 记住用户密码
                //.and()
                .formLogin() //.loginPage("index.html").loginProcessingUrl("login")//使用自定义的登录页面
                .defaultSuccessUrl("/main.html").failureUrl("/common/loginFailed");
                //可从默认的login页面登录，并且登录后跳转到main.html

    }

}
