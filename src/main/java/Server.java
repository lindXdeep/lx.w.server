import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  private static final int PORT = 8080;

  public Server() throws IOException {

    ServerSocket serverSocket = new ServerSocket(PORT);
    System.out.println("Server started: " + serverSocket);

    try (Socket socket = serverSocket.accept();

        BufferedReader in = new BufferedReader(
            new InputStreamReader(
                socket.getInputStream()));

        PrintWriter out = new PrintWriter(
            new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream())),
            true)) {

      System.out.println("Connection accepted: " + socket);
      
      while (true) {

        String msg = in.readLine();

        if (msg.equals("END"))
          break;

        System.out.println("Echoing: " + msg);
        out.println(msg);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
