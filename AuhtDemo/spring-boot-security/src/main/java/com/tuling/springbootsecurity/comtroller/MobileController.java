package com.tuling.springbootsecurity.comtroller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PreDestroy;
import javax.annotation.security.RolesAllowed;

/**
 * @Auther: lxx
 * @Date: 2023/3/15 22:06
 * @Description:
 */
@RestController
@RequestMapping("/mobile")
public class MobileController {
    public MobileController() {
    }

    @GetMapping("/query")
    @PreAuthorize("mobile")
    @Secured("mobile")
    @RolesAllowed("mobile")
    public String query(){
        return "mobile";
    }
}
