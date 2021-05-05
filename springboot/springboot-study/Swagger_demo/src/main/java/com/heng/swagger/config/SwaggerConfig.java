package com.heng.swagger.config;

import org.jcp.xml.dsig.internal.dom.DOMKeyInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 // 开启Swagger2
public class SwaggerConfig {
    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }
    // 配置了Swagger的docket的bean实例
    @Bean
    public Docket docket(Environment environment) {
        // 设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev","test");
        // 通过environment.acceptsProfiles判断是否处在自己设定的环境当中
        boolean flags = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("heng")
                .enable(flags) // enable：是否启动Swagger；如果为false，则Swagger不能在浏览器中访问。
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.heng.swagger.controller"))
                // .paths(PathSelectors.ant("/heng/**"))
                .build();
    }
    private ApiInfo apiInfo() {
        // 作者信息
        final Contact DEFAULT_CONTACT = new Contact("heng", "", "");
        return new ApiInfo(
                "heng's swagger api documentation",
                "Api Documentation",
                "1.0",
                "urn:tos",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }
}