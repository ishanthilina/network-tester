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

    static ArrayList<ConnectionHandler> threads=new ArrayList<ConnectionHandler>();

    public static void main(String[] args) {


        int portNumber = Integer.parseInt(args[0]);

        try {
            // initializing the Socket Server
            ServerSocket serverSocket = new ServerSocket(portNumber);

            //accept connections forever
            while (true) {

                logger.info("Waiting for clients...");
                Socket client = serverSocket.accept();
                logger.info(client.getInetAddress()+" connected");

                ConnectionHandler connectionHandler = new ConnectionHandler(client);
                threads.add(connectionHandler);
                connectionHandler.start();

            }

        } catch (IOException e) {
            logger.error("[IOException] "+e.getMessage());
            e.printStackTrace();
        }

    }

}
