package com.heng.service;

import org.springframework.stereotype.Component;

// zookeeper:服务注册与发现

// 可以被扫描到，在项目一启动就自动注册到注册中心
@Component // 使用了Dubbo后，尽量不要使用@Service注解
public class TicketServiceImpl implements TicketService{
    @Override
    public String getTicket() {
        return "HENG";
    }
}