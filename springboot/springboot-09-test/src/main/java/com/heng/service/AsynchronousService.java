package com.heng.service;

import org.springframework.stereotype.Service;

@Service
public class AsynchronousService {
    public void hello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据正在处理......");
    }
}