import org.eclipse.jetty.server.Server;

/**
 * App
 */
public class App {

  public static void main(String[] args) throws Exception {

    Server server = new Server(8080);

    server.setHandler(new ProcHanler());

    server.start();
    server.join();
  }
}
