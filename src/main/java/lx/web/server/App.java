package lx.web.server;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import lx.web.server.controller.SessionsServlet;
import lx.web.server.controller.UserServlet;
import lx.web.server.model.User;
import lx.web.server.service.AccountService;
import lx.web.server.service.AccountServiceImpl;

/**
 * App
 */
public class App {

  private static int port = 8080;

  private static AccountService accountService = new AccountServiceImpl();

  public static void main(String[] args) throws Exception {

    accountService.addNewUser(new User("test", "123", "email1@email.ru"));
    accountService.addNewUser(new User("admin", "456", "email2@email.ru"));

    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.addServlet(new ServletHolder(new UserServlet(accountService)), "/signup");
    context.addServlet(new ServletHolder(new SessionsServlet(accountService)), "/signin");

    ResourceHandler resource = new ResourceHandler();
    resource.setResourceBase("src/main/java/webapp");

    HandlerList handlers = new HandlerList();
    handlers.setHandlers(new Handler[] {
        resource,
        context
    });

    Server server = new Server(port);
    server.setHandler(handlers);

    server.start();
    System.out.println("Server started!");
    server.join();
  }
}
