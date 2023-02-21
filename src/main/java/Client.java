import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

  private static int PORT = 8080;

  public Client() throws IOException {

    InetAddress inetAddress = InetAddress.getByName(null);
    Socket socket = new Socket(inetAddress, PORT);

    System.out.println("Client started at: " + socket);

    try (BufferedReader in = new BufferedReader(
        new InputStreamReader(
            socket.getInputStream()));

        PrintWriter out = new PrintWriter(
            new BufferedWriter(
                new OutputStreamWriter(
                    socket.getOutputStream())),
            true)) {

      String[] msg = { "hey1", "hey2", "hey3", "END" };
      for (String m : msg) {
        out.println(m);
        System.out.println("Response: " + in.readLine());
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
