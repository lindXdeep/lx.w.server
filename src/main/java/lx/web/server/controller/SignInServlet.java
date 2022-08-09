package lx.web.server.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lx.web.server.service.AccountService;

/**
 * SignInServlet
 */
public class SignInServlet extends HttpServlet {

  private final AccountService accountService;

  public SignInServlet(final AccountService accountService) {
    this.accountService = accountService;
  }

  @Override
  protected void doPost(HttpServletRequest req,
      HttpServletResponse resp)
      throws ServletException, IOException {

    String login = req.getParameter("login");
    String pass = req.getParameter("password");

    boolean loggedIn = accountService.signin(login, pass);

    int status = loggedIn ? HttpServletResponse.SC_OK : HttpServletResponse.SC_UNAUTHORIZED;
    String msg = loggedIn ? "Authorized" : "Unauthorized";

    resp.setContentType("text/html;charset=utf-8");
    resp.getWriter().println(msg);
    resp.setStatus(status);
  }
}
