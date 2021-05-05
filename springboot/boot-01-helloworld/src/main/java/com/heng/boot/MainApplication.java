package com.heng.boot;

import ch.qos.logback.core.db.DBHelper;
import com.heng.boot.bean.Pet;
import com.heng.boot.bean.User;
import com.heng.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主程序类；主配置类
 *  // @SpringBootApplication：这是一个SpringBoot应用
 */
@SpringBootApplication
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.heng.boot")
public class MainApplication {
    public static void main(String[] args) {
        // 1.返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        // 2.查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name: names) {
            System.out.println(name);
        }

        int beanDefinitionCount = run.getBeanDefinitionCount();
        System.out.println(beanDefinitionCount);

        String[] beanNamesForType = run.getBeanNamesForType(CacheAspectSupport.class);
        System.out.println("=====");
        System.out.println(beanNamesForType.length);

        // 3.从容器中获取组件
        String[] beanNamesForType1 = run.getBeanNamesForType(WebMvcAutoConfiguration.class);
        System.out.println("=====");
        System.out.println(beanNamesForType1.length);
//        Pet tom01 = run.getBean("tom", Pet.class);
//        Pet tom02 = run.getBean("tom", Pet.class);
//        System.out.println("组件：" + (tom01 == tom02));
//
//        // 4.com.heng.boot.config.MyConfig$$EnhancerBySpringCGLIB$$84d4c26f@4cee7fa0
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//
//        // 如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否有在容器中。
//        // 保持组件单实例
//        User user = bean.user01();
//        User user1 = bean.user01();
//        System.out.println(user == user1);
//
//        User user01 = run.getBean("user01", User.class);
//        Pet cat = run.getBean("tom", Pet.class);
//        System.out.println("用户的宠物：" + (user01.getPet() == cat));
//
//        // 5.获取组件
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        System.out.println("=====");
//        for (String s: beanNamesForType) {
//            System.out.println(s);
//        }
//
//        DBHelper bean1 = run.getBean(DBHelper.class);
//        System.out.println(bean1);
        boolean tom = run.containsBean("tom");
        System.out.println("容器中tom组件：" + tom);
        boolean user01 = run.containsBean("user01");
        System.out.println("容器中user01组件：" + user01);

        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");
        System.out.println("haha: " + haha);
        System.out.println("hehe: " + hehe);

    }
}
