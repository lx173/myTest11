package com.tuling.security.distributed.uaa;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @Auther: lxx
 * @Date: 2023/3/17 13:41
 * @Description:
 */
@SpringBootApplication
@EnableAuthorizationServer
public class UaaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UaaServerApplication.class,args);
    }
}
