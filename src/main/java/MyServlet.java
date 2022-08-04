import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MyServlet
 */
@SuppressWarnings("serial")
public class MyServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    resp.setContentType("text/html");
    resp.setStatus(HttpServletResponse.SC_OK);
    resp.getWriter().println("<h1>Hello world</h1>");

  }
}