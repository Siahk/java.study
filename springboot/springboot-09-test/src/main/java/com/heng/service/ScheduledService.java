package com.heng.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    // 在一个特定的时间执行这个方法，Timer
    @Scheduled(cron = "0 * * * * 0-7")
    public void hello() {
        System.out.println("Hello，你被执行了！");
    }
}
