package com.heng;

import com.heng.service.UserService;
import com.heng.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroSpringbootApplicationTests {
    @Autowired
    UserServiceImpl userService;
    @Test
    void contextLoads() {
        System.out.println(userService.queryUserByName("张三"));
    }
}
