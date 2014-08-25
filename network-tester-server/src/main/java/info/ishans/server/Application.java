package info.ishans.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ishan on 8/25/14.
 */
public class Application {

    public static void main(String[] args) {

        int portNumber = 9990;

        try {
            // initializing the Socket Server
            ServerSocket serverSocket = new ServerSocket(portNumber);

            System.out.println("Waiting for clients...");
            Socket client = serverSocket.accept();

            Runnable connectionHandler = new ConnectionHandler(client);
            new Thread(connectionHandler).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
