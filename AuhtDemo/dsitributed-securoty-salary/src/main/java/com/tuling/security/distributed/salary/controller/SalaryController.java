package com.tuling.security.distributed.salary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lxx
 * @Date: 2023/3/17 21:52
 * @Description:
 */
@RestController
@RequestMapping("/salary")
public class SalaryController {
    /**
     * 代表一个查薪水的后台接口
     */
    @GetMapping("/query")
    public String query(){
        return "salary info";
    }
    @GetMapping("/query2")
    public String query2(){
        return "salary info2";
    }
}
