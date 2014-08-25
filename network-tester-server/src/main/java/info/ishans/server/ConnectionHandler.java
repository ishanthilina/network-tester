package info.ishans.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by ishan on 8/25/14.
 */
public class ConnectionHandler implements Runnable {

    Socket clientSocket;

    public ConnectionHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream()));

            String nextLine;
            while ((nextLine = in.readLine()) != null) {
                System.out.println(nextLine);
            }
            System.out.println("server - printed");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
