package info.ishans.server;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by ishan on 8/25/14.
 */
public class ConnectionHandler extends Thread {

    private static Logger logger = Logger.getLogger(ConnectionHandler.class);

    Socket clientSocket;

    public ConnectionHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        //serves the accepted socket connection forever
        while(true){
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(
                        clientSocket.getInputStream()));

                String message=in.readLine();
                if(message!=null){
                    logger.info("Received message from "+clientSocket.getInetAddress());
                }
                else{
                    logger.error("Null message received from "+clientSocket.getInetAddress()+". Stopping connection");
                    return;
                }


                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                out.println(message);

            } catch (IOException e) {
                logger.error("[IOException] "+e.getMessage());
                e.printStackTrace();
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
