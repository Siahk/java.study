package com.heng.client;

import java.io.*;
import java.net.Socket;

public class EchoClient {
    private static final String host = "localhost";
    private static final int port = 8000;
    private final Socket socket;

    public EchoClient() throws IOException {
        socket = new Socket(host, port);
    }


    // 主程序
    public static void main(String[] args) throws IOException {
        new EchoClient().talk();
    }


    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream socketOut = socket.getOutputStream();
        return new PrintWriter(socketOut, true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream socketIn = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }

    public void talk() {
        try {
            BufferedReader br = getReader(socket);
            PrintWriter pw = getWriter(socket);
            BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
            String msg;
            while((msg = localReader.readLine()) != null) {

                pw.println(msg);
                System.out.println(br.readLine());

                if(msg.equals("bye"))
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                socket.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}