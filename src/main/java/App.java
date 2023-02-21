import java.io.IOException;
import java.util.List;

/**
 * App
 */
public class App {

  public static void main(String[] args) throws IOException, InterruptedException {

    Runnable server = () -> {
      try {
        new Server();
      } catch (IOException e) {
        e.printStackTrace();
      }
    };

    Runnable client = () -> {
      try {
        new Client();
      } catch (IOException e) {
        e.printStackTrace();
      }
    };

    new Thread(server).start();

    Thread.sleep(1000);
    



    for (int i = 0; i < 100; i++) {
      new Thread(client).start();
    }



  }
}