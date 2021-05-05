package com.heng.demo;

public class B extends Subtraction {
//    public int func1(int a, int b) {
//        return a + b;
//    }
//    public int func2(int a, int b) {
//        return func1(a, b) + 9;
//    }
    A a = new A();
    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    public Integer add2(Integer a, Integer b) {
        return this.a.subtraction(a, b) + 9;
    }
}
