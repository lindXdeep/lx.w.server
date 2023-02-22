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
          buf = packet.getData(); // получаем данные
          String msg = new String(buf, 0, buf.length);

          System.out.print(":> " + msg);

          // Сообщение для ответа клиенту
          String response = "get data: " + msg + " from " +
            packet.getAddress() + ":" + packet.getPort();

          // перегоняем сообщение в баыйты
          buf = msg.getBytes();

          // Формируем покет для отпроавки клиенту
          packet = new DatagramPacket(buf, buf.length,
                                      packet.getAddress(),
                                      packet.getPort());

          // и отправляем клиенту
          socket.send(packet);

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