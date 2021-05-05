package com.siahk.demo04;

import com.siahk.demo02.UserServiceImpl;
import com.siahk.demo03.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 会用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {
    // 被代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    // 生成得到代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    // 处理代理实例，并返回结果：
    @Override
    public Object invoke(Object proxy, @org.jetbrains.annotations.NotNull Method method, Object[] args) throws Throwable {
        log(method.getName());
        Object result= method.invoke(target, args);
        return result;
    }

    public void log(String msg) {
        System.out.println("debug：使用了" + msg + "方法。");
    }


}