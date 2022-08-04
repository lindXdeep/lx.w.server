import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletHandler;

public class App {
  public static void main(String[] args) throws Exception {

    ContextHandler ch = new ContextHandler(); // используется только для ответа на запросы соответствующие URI
    ResourceHandler rh = new ResourceHandler();

    Server server = new Server(8080);

    // Настройка ResourceHandler
    rh.setDirectoriesListed(true);
    rh.setWelcomeFiles(new String[] { "index.html" }); // файл кторый должен быть предоставлен запрашивающей стороне
    rh.setResourceBase("src/main/webapp");

    ch.setContextPath("/hello");
    ch.setHandler(rh);

    server.setHandler(ch); // регистрируем на сервере ContextHandler

    server.start();
    server.join();

  }
}
