import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {

  private DatagramSocket socket;
  private DatagramPacket packet;
  private byte[] buf;

  public Server() throws SocketException, IOException {

    socket = new DatagramSocket(8080);             // открываем сокет и слушаем 8080 порт
    System.out.println("waiting data...");

    while (true) {

      this.clear();

      socket.receive(packet);                      // ожидаем пакеты от клиента
      buf = packet.getData();                      // Как только пакеты придут,
      String msg = new String(buf, 0, buf.length); // вытаскиеваем данные из пакета
      System.out.println(msg);                     // и выводим в консоль
    }
  }

  private void clear() {
    this.buf = new byte[256];
    this.packet = new DatagramPacket(buf, buf.length);
  }
}