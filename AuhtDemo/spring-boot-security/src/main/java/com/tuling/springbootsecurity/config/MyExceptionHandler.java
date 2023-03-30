package com.tuling.springbootsecurity.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

/**
 * @Auther: lxx
 * @Date: 2023/3/16 16:34
 * @Description:
 */
@ControllerAdvice //切面 通知
public class MyExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public String error(){
        return "no_auth";
    }
}
