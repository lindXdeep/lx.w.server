import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection extends Thread {

  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  private static int count;

  public Connection(Socket socket) throws IOException {

    this.socket = socket;

    this.in = new BufferedReader(
        new InputStreamReader(
            socket.getInputStream()));

    this.out = new PrintWriter(
        new BufferedWriter(
            new OutputStreamWriter(
                socket.getOutputStream())),
        true);

    System.out.println("Connect " + ++count + ": logged in");
  }

  @Override
  public void run() {

    try {
      while (true) {

        String msg = in.readLine();

        if (msg.equals("END"))
          break;
  
        System.out.print("Connect " + count + ":> " + msg + " ---> ");
  
        out.println(msg);
      }
    } catch (IOException | NullPointerException e) {
      e.printStackTrace();
      kill();
    } finally {
      kill();
    }
  }

  public void kill() {
    try {
      this.socket.close();
      System.out.println("Connect: " + count + " Closing . . .");
      this.currentThread().interrupt();
    } catch (IOException | NullPointerException e) {
      System.err.println("Socket not closet. . .");
    }
  }
}
