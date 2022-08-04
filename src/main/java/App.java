import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class App {
  public static void main(String[] args) throws Exception {

    // ServletHandler - простой контекстный обработчик через сервлет
    ServletHandler sh = new ServletHandler();

    Server server = new Server(8080);
    server.setHandler(sh); // регистрируем на сервере ServletHandler

    // Маппим путь которому будет соответвоать необратобанный сервлет
    // Это не настроенный с помощью @WebServlet или web.xml или др. способом.
    sh.addServletWithMapping(MyServlet.class, "/*");

    server.start();
    server.join();

  }
}
