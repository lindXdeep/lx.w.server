import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * App
 */
public class App {

  public static void main(String[] args) throws Exception {

    ResourceHandler rh = new ResourceHandler();
    rh.setDirectoriesListed(true);
    rh.setWelcomeFiles(new String[] { "index.jsp" }); // файл кторый должен быть предоставлен запрашивающей стороне
    rh.setResourceBase("src/main/webapp");

    ContextHandler ch = new ContextHandler(); // используется только для ответа на запросы соответствующие URI
    ch.setContextPath("/hello");
    ch.setHandler(rh);

    Server server = new Server(8080);
    server.setHandler(ch);
    server.setHandler(rh);

    server.start();
    server.join();
  }
}
