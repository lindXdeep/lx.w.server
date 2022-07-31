import java.io.IOException;

import org.eclipse.jetty.server.Server;

/**
 * App
 */
public class App {

  public static void main(String[] args) throws Exception {
    
    Server server = new Server(8080);

    server.dumpStdErr();
    server.setHandler(new MyHandler());
    
    server.start();
    server.join();

  }
}