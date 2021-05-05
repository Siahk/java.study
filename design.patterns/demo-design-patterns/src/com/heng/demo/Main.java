package com.heng.demo;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3=" + a.subtraction(11, 3));
        System.out.println("1-8=" + a.subtraction(1, 8));
        System.out.println("------------");
        B b = new B();
        System.out.println("11-3=" + b.a.subtraction(11, 3));
        System.out.println("1+8=" + b.add(1, 8));
        System.out.println("11+3+9=" + b.add2(11, 3));
    }
}
