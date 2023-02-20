import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  private static final int PORT = 8080;

  public Server() throws IOException {

    ServerSocket serverSocket = new ServerSocket(PORT);
    System.out.println("Server started: " + serverSocket);

    try (Socket socket = serverSocket.accept()) {

      System.out.println("Connection accepted: " + socket);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
