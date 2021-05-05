package com.heng.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    // ShiroFilterFactoryBean--3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager")
                                                            DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        // 添加Shiro的内置过滤器

        /*
        * anon：无需认证就可以访问
        * authc：必须认证了才能访问
        * user：必须拥有 记住我（rememberMe） 功能才能使用
        * perms：拥有对某个资源的权限才能访问
        * roles：又有某个角色权限才能访问
        */

        // 拦截
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        // 授权,正常情况下，没有授权会跳转到未授权页面
        filterChainDefinitionMap.put("/user/add", "perms[user:add]");
        filterChainDefinitionMap.put("/user/update", "perms[user:update]");
        /*
        * filterChainDefinitionMap.put("/user/add", "authc");
        * filterChainDefinitionMap.put("/user/update", "authc");
        */
        filterChainDefinitionMap.put("/user/*", "authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //设置登录的请求
        bean.setLoginUrl("/login");
        bean.setUnauthorizedUrl("/unauthorized");
        return bean;
    }

    // DefaultWebSecurityManager--2
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        securityManager.setRealm(userRealm);
        return securityManager;
    }

    // 创建 realm 对象，自定义--1
    @Bean(name = "userRealm")
    public UserRealm userRealm() {
        return new UserRealm();
    }

    // 整合ShiroDialect：用来整合 Shiro thymeleaf
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
