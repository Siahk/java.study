package com.heng.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EchoPlayer {

    public String echo(String msg) {
        return "echo:" + msg;
    }

    public void talk() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg;
        while ((msg = br.readLine()) != null){
            System.out.println(echo(msg));
            if(msg.equals("bye")) // 当用户输入“bye”时，结束程序。
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        new EchoPlayer().talk();
    }
}
