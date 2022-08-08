import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * App
 */
public class App {

  public static String webdir = "src/main/webapp";
  public static String descriptor = webdir + "/WEB-INF/web.xml";

  public static void main(String[] args) throws Exception {

    WebAppContext wc = new WebAppContext();
    wc.setContextPath("/myapp");
    wc.setDescriptor(descriptor);
    wc.setResourceBase(webdir);
    wc.setParentLoaderPriority(true);

    Server server = new Server(8080);
    server.setHandler(wc);
    // server.dumpStdErr();

    server.start();
    server.join();
  }
}
