package info.ishans.client;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by ishan on 8/25/14.
 */
public class Application {

    public static void main(String[] args) {

        //Creating a SocketClient object
        SocketClient client = new SocketClient ("localhost",9990);
        try {
            //trying to establish connection to the server
            client.connect();
            //if successful, read response from server
            client.readResponse();

        } catch (UnknownHostException e) {
            System.err.println("Host unknown. Cannot establish connection");
        } catch (IOException e) {
            System.err.println("Cannot establish connection. Server may not be up."+e.getMessage());
        }
    }
}
