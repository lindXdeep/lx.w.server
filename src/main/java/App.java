import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * App
 */
public class App {

  public static void main(String[] args) throws Exception {

    ServletHandler sh = new ServletHandler();
    sh.addServletWithMapping(MyServlet.class, "/");

    Server server = new Server(8080);
    server.setHandler(sh);

    server.start();
    server.join();
  }
}
