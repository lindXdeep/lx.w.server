import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * App
 */
public class App {

  public static String webdir = "src/main/webapp";
  public static String descriptor = webdir + "/WEB-INF/web.xml";

  public static void main(String[] args) throws Exception {

    Server server = new Server(8080);

    WebAppContext wc = new WebAppContext();
    wc.setContextPath("/myapp");
    wc.setDescriptor(descriptor); // deployment descriptor
    wc.setResourceBase(webdir);   // document root for the static resources for the context. 
    wc.setParentLoaderPriority(true);

    server.setHandler(wc);        // The handler is set for the context handler object.

    server.dumpStdErr();


    server.start();
    server.join();

  }
}