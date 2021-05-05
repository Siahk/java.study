import java.io.IOException;
import java.net.*;

public class ConnectTester {
    public static void main(String[] args) {
        String host = " localhost";
        int port = 25;

        if (args.length > 1) {
            host = args[0];
            port = Integer.parseInt(args[1]);
        }

        new ConnectTester().connect(host, port);
    }

    public void connect(String host, int port) {
        SocketAddress remoteAddr = new InetSocketAddress(host, port);
        Socket socket = null;
        String result = "";

        try {
            System.currentTimeMillis();
            socket = new Socket();
            socket.connect(remoteAddr, 1000);
        } catch (BindException e) {
            result = "Local address and port can't be binded";
        } catch (UnknownHostException e) {
            result = "Unknown Host";
        } catch (ConnectException e) {
            result = "Connection Refused";
        } catch (SocketTimeoutException e) {
            result = "TimeOut";
        } catch (IOException e) {
            result = "failure";
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(remoteAddr + " : " + result);
    }
}
