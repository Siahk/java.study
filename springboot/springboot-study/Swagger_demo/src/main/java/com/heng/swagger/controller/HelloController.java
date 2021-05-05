package com.heng.swagger.controller;

import com.heng.swagger.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(value = "/hello")
    public String Hello() {
        return "hello";
    }
    @PostMapping("/user")
    public User user() {
        return new User();
    }
}
