package info.ishans.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by ishan on 8/25/14.
 */
public class SocketClient {

    private String hostname;
    private int port;
    Socket socketClient;

    public SocketClient(String hostname, int port){
        this.hostname = hostname;
        this.port = port;
    }

    public void connect() throws UnknownHostException, IOException {
        System.out.println("Attempting to connect to "+hostname+":"+port);
        socketClient = new Socket(hostname,port);
        System.out.println("Connection Established");
    }

    public void readResponse() throws IOException{
        String userInput;
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

        System.out.println("Response from server:");
        while ((userInput = stdIn.readLine()) != null) {
            System.out.println(userInput);
        }
        System.out.println("client - done");
    }



}
