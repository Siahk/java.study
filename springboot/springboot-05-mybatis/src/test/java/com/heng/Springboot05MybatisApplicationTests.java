package com.heng;

import com.heng.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.SQLException;

@SpringBootTest
class Springboot05MybatisApplicationTests {
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads(){
    }
}