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

        String url=args[0];
        int port=Integer.parseInt(args[1]);

        //Creating a SocketClient object
        SocketClient client = new SocketClient (url,port);

        while(true){
            try {
                client.connect();

                //send/receive messages from/to the server forever
                while(true){


                        logger.info("Sending message to "+url+":"+port);

                        client.sendMessage("DD");

                    logger.info("Reading message from "+url+":"+port);

                        client.readResponse();

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                }


            } catch (UnknownHostException e) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                logger.error("[UnknownHostException] "+url+":"+port+" "+e.getMessage());

            }
            catch (IOException e) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                logger.error("[IOException] "+url+":"+port+" "+e.getMessage());
            }
        }




    }
}
