package info.ishans.client;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by ishan on 8/25/14.
 */
public class ClientApplication {

    private static Logger logger = Logger.getLogger(ClientApplication.class);

    public static void main(String[] args) {

        if(args.length<5){
            logger.info("Invalid number of parameters");
            printUsage();
            return;
        }

        String url = args[0];
        int port = Integer.parseInt(args[1]);
        double maxDelay=Double.parseDouble(args[2]);
        int requestInterval=Integer.parseInt(args[3]);
        int timeout=Integer.parseInt(args[4]);

        //Creating a SocketClient object
        SocketClient client = new SocketClient(url, port,timeout);

        while (true) {
            try {
                client.connect();

                //send/receive messages from/to the server forever
                while (true) {


                    logger.info("Sending message to " + url + ":" + port);

                    long sentTime = System.currentTimeMillis();

                    String message="DD";
                    client.sendMessage(message);

                    logger.info("Reading message from " + url + ":" + port);

                    String response=client.readResponse();
                    if(!(message.equalsIgnoreCase(response))){
                        throw new IOException("Response message was invalid. Response: "+response);
                    }
                    long receivedTime = System.currentTimeMillis();

                    if((receivedTime-sentTime)>maxDelay){
                        throw new IOException("Time difference is greater than "+maxDelay+" milliseconds");
                    }

                    try {
                        Thread.sleep(requestInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }


            } catch (UnknownHostException e) {
                try {
                    Thread.sleep(requestInterval);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                logger.error("[UnknownHostException] " + url + ":" + port + " - Reason:" + e.getMessage());

            } catch (IOException e) {
                try {
                    Thread.sleep(requestInterval);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                logger.error("[IOException] " + url + ":" + port + " - Reason:" + e.getMessage());
            }
        }


    }

    private static void printUsage(){
        System.out.println("Required number of arguments: 5");
        System.out.println("Argument 1: URL/IP to connect to");
        System.out.println("Argument 2: Port to connect to");
        System.out.println("Argument 3: Maximum delay that can occur between sending a message and receiving a response (in ms)");
        System.out.println("Argument 4: How frequently should the client try sending messages (in ms)");
        System.out.println("Argument 5: Timeout for read operations (in ms)");

    }
}
