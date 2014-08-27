package info.ishans.server;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by ishan on 8/25/14.
 */
public class ServerApplication {

    private static Logger logger = Logger.getLogger(ServerApplication.class);

    public static void main(String[] args) {

        if(args.length<1){
            logger.info("Invalid number of parameters");
            printUsage();
            return;
        }


        int portNumber = Integer.parseInt(args[0]);
        int responseInterval=Integer.parseInt(args[1]);

        try {
            // initializing the Socket Server
            ServerSocket serverSocket = new ServerSocket(portNumber);

            //accept connections forever
            while (true) {

                logger.info("Waiting for clients...");
                Socket client = serverSocket.accept();
                logger.info(client.getInetAddress()+" connected");

                ConnectionHandler connectionHandler = new ConnectionHandler(client,responseInterval);
                connectionHandler.start();

            }

        } catch (IOException e) {
            logger.error("[IOException] "+e.getMessage());
            e.printStackTrace();
        }

    }

    private static void printUsage(){
        System.out.println("Required number of arguments: 1");
        System.out.println("Argument 1: Port to connect to");
    }

}
