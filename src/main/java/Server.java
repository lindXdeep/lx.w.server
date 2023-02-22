import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {

  private static final int PORT = 8080;
  private byte[] buf = new byte[256];

  private DatagramPacket packet;

  public Server() {

    try (DatagramSocket socket = new DatagramSocket(PORT)) {

      System.out.println("Server started on: " + PORT);

      while (true) {

        this.clear(); // очищаем buffer и packet

        try {
          socket.receive(packet); // ждем пакеты
          new Handler(packet, socket).start();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    } catch (SocketException e) {
      e.printStackTrace();
    }
  }

  private void clear() {
    this.buf = new byte[256];
    this.packet = new DatagramPacket(buf, buf.length);
  }
}