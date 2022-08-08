import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class App {
  public static void main(String[] args) throws Exception {

    ServletContextHandler sch = new ServletContextHandler(ServletContextHandler.SESSIONS);
    sch.setContextPath("/");
    sch.setResourceBase(System.getProperty("java.io.tmpdir"));
    sch.addServlet(DefaultServlet.class, "/");
    sch.addServlet(MyServlet.class, "/hello");

    Server server = new Server(8080);
    server.setHandler(sch); // регистрируем на сервере ServletContextHandler

    server.start();
    server.join();
  }
}
