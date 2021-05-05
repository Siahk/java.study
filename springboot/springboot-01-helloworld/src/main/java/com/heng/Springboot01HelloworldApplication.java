package com.heng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// @SpringBootApplication：标注这个类是一个spingboot应用：启动类下的所有资源被导入。
@SpringBootApplication
public class Springboot01HelloworldApplication {

    public static void main(String[] args) {
        // 将spirngboot应用启动
        SpringApplication.run(Springboot01HelloworldApplication.class, args);
    }

}