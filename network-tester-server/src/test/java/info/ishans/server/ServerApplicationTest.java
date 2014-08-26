package info.ishans.server;

import org.junit.Test;

import static org.junit.Assert.*;

public class ServerApplicationTest {

    @Test
    public void testMain() throws Exception {

        ServerApplication serverApplication=new ServerApplication();
        serverApplication.main(new String[]{"DD"});

    }
}