import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

/**
 * MyHandler
 */
public class MyHandler extends AbstractHandler {

  @Override
  public void handle(String target,
      Request baseReq,
      HttpServletRequest req,
      HttpServletResponse resp)
      throws IOException, ServletException {

    System.out.println("target     :" + target);
    System.out.println("baseRequest:" + baseReq.getRequestURI());
    System.out.println("request    :" + req.getRequestURI());

    resp.setContentType("text/html; charset=utf-8");
    resp.setStatus(HttpServletResponse.SC_OK);

    PrintWriter out = resp.getWriter();
    out.println("<h1>Hello world!</h1>");

    baseReq.setHandled(true);

  }
}