import java.io.IOException;

/**
 * App
 */
public class App {

  private static int id;

  public static void main(String[] args) throws IOException, InterruptedException {

    Runnable server = () -> {
      new Server();
    };

    Runnable client = () -> {
      try {      
        new Client(id++);
      } catch (IOException e) {
        e.printStackTrace();
      }
    };

    new Thread(server).start();

    Thread.sleep(1000);

    for (int i = 0; i < 10000; i++) {
      new Thread(client).start();
    }
  }
}