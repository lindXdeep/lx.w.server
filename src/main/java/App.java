import java.io.IOException;

/**
 * App
 */
public class App {

  public static void main(String[] args) throws IOException, InterruptedException {

    Runnable server = () -> {
      new Server();
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

   new Thread(client).start();

  }
}