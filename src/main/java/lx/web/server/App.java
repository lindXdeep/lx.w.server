package lx.web.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import lx.web.server.controller.SignInServlet;
import lx.web.server.controller.SignUpServlet;
import lx.web.server.service.AccountService;
import lx.web.server.service.AccountServiceImpl;

/**
 * App
 */
public class App {

  private static int port = 8080;

  private static AccountService accountService = new AccountServiceImpl();

  public static void main(String[] args) throws Exception {

    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");
    context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");

    Server server = new Server(port);
    server.setHandler(context);

    server.start();
    System.out.println("Server started!");
    server.join();
  }
}
