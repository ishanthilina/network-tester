package info.ishans.client;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by ishan on 8/25/14.
 */
public class SocketClient {

    private static Logger logger = Logger.getLogger(SocketClient.class);
    private String hostname;
    private int port;
    Socket socketClient;

    public SocketClient(String hostname, int port){
        this.hostname = hostname;
        this.port = port;
    }

    public void connect() throws IOException {
        logger.info("Attempting to connect to "+hostname+":"+port);
        socketClient = new Socket();
        socketClient.connect(new InetSocketAddress(hostname,port), 1000);
        socketClient.setSoTimeout(1000);
        logger.info("Connection established to "+hostname+":"+port);
    }

    public void readResponse() throws IOException{
        String userInput;
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

        String message=stdIn.readLine();
        if(message==null){
           logger.error("Connection Failure "+hostname+":"+port);
            throw new IOException();
        }
        //System.out.println("client - done");
    }

    public void sendMessage(String message) throws IOException {
        PrintWriter out =
                new PrintWriter(socketClient.getOutputStream(), true);
        out.println(message);
    }



}
