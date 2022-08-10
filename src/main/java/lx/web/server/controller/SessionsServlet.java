package lx.web.server.controller;

import static javax.servlet.http.HttpServletResponse.SC_OK;
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import lx.web.server.model.User;
import lx.web.server.service.AccountService;

/**
 * SignInServlet
 */
public class SessionsServlet extends HttpServlet {

  private final AccountService accountService;

  public SessionsServlet(final AccountService accountService) {
    this.accountService = accountService;
  }

  @Override
  protected void doGet(HttpServletRequest req,
      HttpServletResponse resp)
      throws ServletException, IOException {

    String sessionId = req.getSession().getId();
    User user = accountService.getUserBySessionId(sessionId);

    resp.setContentType("application/json;charset=utf-8");

    if (user != null) {
      resp.getWriter().println(new Gson().toJson(user));
    }

    resp.setStatus(user == null ? SC_UNAUTHORIZED : SC_OK);
  }

  @Override
  protected void doPost(HttpServletRequest req,
      HttpServletResponse resp)
      throws ServletException, IOException {

    String login = req.getParameter("login");
    String pass = req.getParameter("password");

    resp.setContentType("test/html;charset=utf-8");

    if (login == null || pass == null) {
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }

    User user = accountService.getUserByLogIn(login);

    if (user == null || !pass.equals(user.getPassword())) {
      resp.getWriter().println("Unauthorized");
      resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }

    accountService.addSession(req.getSession().getId(), user);
    resp.getWriter().println("Authorized: " + login);
    resp.setStatus(HttpServletResponse.SC_OK);

  }

  @Override
  protected void doDelete(HttpServletRequest req,
      HttpServletResponse resp)
      throws ServletException, IOException {

    String sessionId = req.getSession().getId();
    User user = accountService.getUserBySessionId(sessionId);
    int status = (user == null ? HttpServletResponse.SC_UNAUTHORIZED : HttpServletResponse.SC_OK);

    resp.setContentType("text/html;charset=utf-8");

    if (user != null) {
      accountService.deleteSession(sessionId);
      resp.getWriter().println("Good Bye!");
    }

    resp.setStatus(status);
  }
}
