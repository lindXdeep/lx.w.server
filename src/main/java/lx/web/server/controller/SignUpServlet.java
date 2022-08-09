package lx.web.server.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lx.web.server.service.AccountService;

/**
 * SignUpServlet
 */
public class SignUpServlet extends HttpServlet {

  private final AccountService accountService;

  public SignUpServlet(final AccountService accountService) {
    this.accountService = accountService;
  }

  @Override
  protected void doPost(HttpServletRequest req,
      HttpServletResponse resp)
      throws ServletException, IOException {

    String login = req.getParameter("login");
    String pass = req.getParameter("password");

    accountService.signup(login, pass);

    resp.setContentType("text/html;charset=utf-8");
    resp.getWriter().println("Signed UP!");
    resp.setStatus(HttpServletResponse.SC_OK);
  }
}
