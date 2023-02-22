import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

  private static final int PORT = 8080;
  private DatagramSocket socket;
  private DatagramPacket packet;
  private InetAddress iAdd;

  private byte[] buf = new byte[256];
  private BufferedReader in;

  public Client() throws IOException {

    iAdd = InetAddress.getByName("127.0.0.1");
    socket = new DatagramSocket();

    // Читаем даннные с косоли в буффер
    in = new BufferedReader(new InputStreamReader(System.in));

    while (true) {

      String msg = in.readLine();
      buf = msg.getBytes();

      // отправляем данные
      packet = new DatagramPacket(buf, buf.length, iAdd, PORT);
      socket.send(packet);
    }
  }
}