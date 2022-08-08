import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

/**
 * ProcHanler
 */
public class MyHanler extends AbstractHandler {

  @Override
  public void handle(String target,
      Request baseRequest,
      HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {

    System.out.println("target     :" + target);
    System.out.println("baseRequest:" + baseRequest.getRequestURI());
    System.out.println("request    :" + request.getRequestURI());

    response.setContentType("text/html; charset=utf-8");
    response.setStatus(HttpServletResponse.SC_OK);

    PrintWriter out = response.getWriter();
    out.println("<h1>Hello world!</h1>");

    baseRequest.setHandled(true);
  }
}
