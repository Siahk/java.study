package com.heng.demo;

import java.io.IOException;
import java.net.Socket;

public class PortScanner {
    public static void main(String[] args) {
        String host="localhost";
        new PortScanner().scan(host);
    }

    public void scan(String host){
        Socket socket=null;
        for(int port = 1; port < 1024; port++){
            try{
                socket = new Socket(host, port);
                System.out.println("There is a server on port " + port);
            } catch(IOException e){
                e.printStackTrace();
            } finally {
                try{
                if(socket != null) socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}