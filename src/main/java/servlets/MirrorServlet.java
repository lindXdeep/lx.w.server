package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MirrorServlet
 */
public class MirrorServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req,
      HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html;charset=utf-8");
    resp.setStatus(HttpServletResponse.SC_OK);

    String value = req.getParameter("key");

    resp.getWriter().println(value != null ? value : "");

  }
}
