package com.heng.controller;

import com.heng.service.AsynchronousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsynchronousController {
    @Autowired
    AsynchronousService asynchronousService;

    @GetMapping(value = "/hello")
    public String hello() {
        asynchronousService.hello(); // 停止三秒
        return "0K";
    }
}

