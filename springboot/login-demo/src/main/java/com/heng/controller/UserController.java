package com.heng.controller;

import com.heng.pojo.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @GetMapping(value = "/index")
    public String index() {
        return "/index";
    }
    @GetMapping("/test")
    public String test() {
        return "/test";
    }
    @GetMapping("/logout")
    public String logout() {
        return "/index";
    }
    @GetMapping("/login")
    public String login() {
        return "/login";
    }
}