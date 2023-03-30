package com.tuling.security.distributed.salary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @Auther: lxx
 * @Date: 2023/3/17 13:50
 * @Description:
 */
@SpringBootApplication
@EnableResourceServer
public class SalaryApplication {
    public static void main(String[] args) {
        SpringApplication.run(SalaryApplication.class,args);
    }
}
