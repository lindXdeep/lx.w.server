import java.net.InetSocketAddress;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import servlets.MirrorServlet;

/**
 * App
 */
public class App {

  private static int port = 8080;

  public static void main(String[] args) throws Exception {

    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.addServlet(MirrorServlet.class, "/mirror");

    Server server = new Server(port);
    server.setHandler(context);

    server.start();
    System.out.println("Server started!");
    server.join();
  }
}
