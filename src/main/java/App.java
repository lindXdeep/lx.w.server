import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;

/**
 * App
 */
public class App {

  public static void main(String[] args) throws Exception {
    
    Server server = new Server(8080);

    ContextHandler ch = new ContextHandler();
    ch.setContextPath("/hello");
    ch.setHandler(new MyHandler()); // A `ContextHandler` is instantiated and a path is set.
    
    server.setHandler(ch);          // The handler is set for the context handler object.
    
    server.start();
    server.join();
    
  }
}