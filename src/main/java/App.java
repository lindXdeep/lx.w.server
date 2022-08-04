import org.eclipse.jetty.server.Server;
<<<<<<< HEAD
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletHandler;
=======
import org.eclipse.jetty.webapp.WebAppContext;
>>>>>>> parent of ed8d4e8 (ServletHandler)

/**
 * App
 */
public class App {

  public static String webdir = "src/main/webapp";
  public static String descriptor = webdir + "/WEB-INF/web.xml";

  public static void main(String[] args) throws Exception {

<<<<<<< HEAD
    ContextHandler ch = new ContextHandler(); // используется только для ответа на запросы соответствующие URI
    ResourceHandler rh = new ResourceHandler();

    Server server = new Server(8080);

    // Настройка ResourceHandler
    rh.setDirectoriesListed(true);
    rh.setWelcomeFiles(new String[] { "index.html" }); // файл кторый должен быть предоставлен запрашивающей стороне
    rh.setResourceBase("src/main/webapp");

    ch.setContextPath("/hello");
    ch.setHandler(rh);

    server.setHandler(ch); // регистрируем на сервере ContextHandler
=======
    Server server = new Server(8080);

    WebAppContext wc = new WebAppContext();
    wc.setContextPath("/myapp");
    wc.setDescriptor(descriptor); // deployment descriptor
    wc.setResourceBase(webdir);   // document root for the static resources for the context. 
    wc.setParentLoaderPriority(true);

    server.setHandler(wc);        // The handler is set for the context handler object.

    server.dumpStdErr();

>>>>>>> parent of ed8d4e8 (ServletHandler)

    server.start();
    server.join();

  }
}