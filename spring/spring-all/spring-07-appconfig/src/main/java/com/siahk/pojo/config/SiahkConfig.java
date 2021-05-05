package com.siahk.pojo.config;

import com.siahk.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

// 这个也会被Spring容器托管，注册到容器中，因为它也是一个@Component。
// @Configuration 代表这是一个配置类，和bean.xml是一样的。
@Configuration
@Component("com.siahk.pojo")
@Import(com.siahk.pojo.config.SiahkConfig2.class)
public class SiahkConfig {

    // 注册一个Bean就相当于之前写的一个Bean标签。
    // 这个方法的名字就相当于bean标签中的id属性。
    // 这个方法的返回值，就相当于bean标签中的class属性。
    @Bean
    public User user(){
        return new User(); // 就是返回要注入到bean的对象。
    }
}