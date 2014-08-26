package info.ishans.client;

import static org.junit.Assert.*;

public class ClientApplicationTest {

    @org.junit.Test
    public void testMain() throws Exception {
        ClientApplication clientApplication=new ClientApplication();
        clientApplication.main(new String[]{"DD"});

    }
}