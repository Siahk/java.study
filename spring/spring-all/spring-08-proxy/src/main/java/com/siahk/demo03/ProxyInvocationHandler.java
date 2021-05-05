package com.siahk.demo03;

import com.siahk.demo03.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 会用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {
    // 被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),rent.getClass().getInterfaces(),this);
    }
    // 处理代理实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 动态代理的本质，就是使用放射机制实现。
        seeHouse();
        Object result= method.invoke(rent, args);
        fare();
        return null;
    }

    public void seeHouse() {
        System.out.println("zhongjiekanfangzi.");
    }

    public void fare() {
        System.out.println("shouzhongjiefei");
    }
}
