import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  private static final int PORT = 8080;

  public Server() throws IOException {

    ServerSocket serverSocket = new ServerSocket(PORT);    // Создаем серверный сокет и вешаем на порт
    System.out.println("Server started: " + serverSocket);

    try {
      while (true) {
        Socket socket = serverSocket.accept();             // Блокируется до возникновения нового соединения
        try {                                              // Как только клиент подключился
          new Connection(socket).start();                  // создаем сервер в отдельном потоке
        } catch (IOException e) {                          // Если завершится неудачей, закрывается сокет, или, поток закроет его.
          socket.close();
        }
      }
    } catch (IOException e) {
      System.out.println("Server offline...");
      serverSocket.close();
    }
  }
}