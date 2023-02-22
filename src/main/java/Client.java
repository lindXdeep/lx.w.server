import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client {

  private int id;

  private static final int PORT = 8080;
  private InetAddress iAdd;

  private byte[] buf = new byte[256];
  private DatagramPacket packet;

  public static void main(String[] args) throws UnknownHostException {
    new Client();
  }

  public Client() throws UnknownHostException {

    iAdd = InetAddress.getByName("127.0.0.1");

    try (DatagramSocket socket = new DatagramSocket()) {

      String[] messages = { "hey1:", "hey2", "hey3", "END" };
      for (String msg : messages) {

        // отправляем на сервер
        buf = (msg + "id:" + id).getBytes();
        packet = new DatagramPacket(buf, 0, buf.length, iAdd, PORT);
        socket.send(packet);

        this.clear();

        // получаем от сeвера
        socket.receive(packet);
        buf = packet.getData();
        msg = new String(buf, 0, buf.length);
        System.out.println("responce to: " + id + " " + msg);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void clear() {

    this.buf = new byte[246];
    this.packet = new DatagramPacket(buf, buf.length);
  }
}