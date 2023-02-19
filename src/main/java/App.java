import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * App
 */
public class App {

  public static void main(String[] args) throws UnknownHostException {

    InetAddress iAddr = InetAddress.getLocalHost();
    System.out.println(iAddr);                        // lindx/127.0.1.1

    System.out.println(iAddr.getHostName());          // lindx
    System.out.println(iAddr.getHostAddress());       // 127.0.1.1

    System.out.println(iAddr.getCanonicalHostName()); // lindx
    System.out.println(iAddr.getLoopbackAddress());   // localhost/127.0.0.1

    byte[] address = iAddr.getAddress();

    for (byte b : address)
      System.out.print(b);                            // 127011
  }
}