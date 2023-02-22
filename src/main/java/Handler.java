import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Handler extends Thread {

  private static int count;

  private byte[] buf;
  private DatagramPacket packet;
  private DatagramSocket socket;

  public Handler(DatagramPacket packet, DatagramSocket socket) {

    this.packet = packet;
    this.socket = socket;
    System.out.println("thread: " + count++);
  }

  @Override
  public void run() {

    buf = packet.getData(); // получаем данные
    String msg = new String(buf, 0, buf.length).trim();

    System.out.println(":> " + msg);

    if (msg.equals("END")) {
      this.currentThread().interrupt();
      socket.close();
      System.exit(0);
    }
    // Сообщение для ответа клиенту
    String response = "get data: " + msg + " from " +
        packet.getAddress() + ":" + packet.getPort();

    // перегоняем сообщение в баыйты
    buf = response.getBytes();

    // Формируем покет для отпроавки клиенту
    packet = new DatagramPacket(buf, buf.length,
        packet.getAddress(),
        packet.getPort());

    // и отправляем клиенту
    try {
      socket.send(packet);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
