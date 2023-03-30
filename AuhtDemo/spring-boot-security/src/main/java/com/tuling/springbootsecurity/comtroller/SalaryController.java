package com.tuling.springbootsecurity.comtroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lxx
 * @Date: 2023/3/15 22:07
 * @Description:
 */
@RestController
@RequestMapping("/salary")
public class SalaryController {
    @GetMapping("/query")
    public String query(){
        return "salary";
    }
}
