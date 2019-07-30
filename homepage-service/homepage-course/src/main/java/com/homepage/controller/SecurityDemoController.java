package com.homepage.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityDemoController {

    /**
     * http://localhost:9000/hp/homepage-course/index
     *
     * @return str
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }


    @RequestMapping("/common")
    public String commonAcces() {
        return "only login can view";
    }

    @RequestMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String ad() {
        return "only admin can access";
    }


}
