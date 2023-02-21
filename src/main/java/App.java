import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * App
 */
public class App {

  public static void main(String[] args) throws IOException {

    Runnable server = () -> {
      try {
        new Server();
      } catch (IOException e) {
        e.printStackTrace();
      }
    };

    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    Runnable client = () -> {
      try {
        new Client();
      } catch (IOException e) {
        e.printStackTrace();
      }
    };

    new Thread(server).start();
    new Thread(client).start();
  


    
    





  }
}