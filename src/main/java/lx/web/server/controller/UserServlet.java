package lx.web.server.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;

import com.google.gson.Gson;

import lx.web.server.model.User;
import lx.web.server.service.AccountService;

/**
 * SignUpServlet
 */
public class UserServlet extends HttpServlet {

  private final AccountService accountService;

  public UserServlet(final AccountService accountService) {
    this.accountService = accountService;
  }

  // get public user profile
  @Override
  protected void doGet(HttpServletRequest req,
      HttpServletResponse resp)
      throws ServletException, IOException {

    String login = req.getParameter("login");
    String pass = req.getParameter("password");

    User user = accountService.getUserByLogIn(login);

    resp.setContentType("application/json;charset=utf-8");

    if (user != null) {
      resp.getWriter().println(new Gson().toJson(user));
    }

    resp.setStatus(user == null ? SC_UNAUTHORIZED : SC_OK);
  }

  // sign up
  @Override
  protected void doPost(HttpServletRequest req,
      HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html;charset=utf-8");

    String login = req.getParameter("login");
    String pass = req.getParameter("password");

    if (login == null || pass == null) {
      resp.getWriter().println(SC_BAD_REQUEST);
      return;
    }

    User user = accountService.getUserByLogIn(login);

    if (user != null && user.equals(login)) {
      resp.setStatus(SC_BAD_REQUEST);
      return;
    }

    accountService.addNewUser(new User(login, pass)); 
    resp.getWriter().println("Authorized: " + login);
    resp.setStatus(SC_OK);
  }

  // change profile
  protected void doPut(HttpServletRequest req,
      HttpServletResponse resp)
      throws ServletException, IOException {

    // TODO: edit profile

  }

  // unregister
  @Override
  protected void doDelete(HttpServletRequest req,
      HttpServletResponse resp)
      throws ServletException, IOException {
  }
}
