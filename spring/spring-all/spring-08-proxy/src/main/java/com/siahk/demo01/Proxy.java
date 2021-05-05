package com.siahk.demo01;

public class Proxy implements Rent {
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        host.rent();
        System.out.println("中介出租房子");
    }

    // 看房
    public void seeHouse() {
        System.out.println("Proxy seeHouse.");
    }

    // 合同
    public void hetong() {
        System.out.println("hetong");
    }

    // 中介费
    public void fare(){
        System.out.println("fare");
    }
}
