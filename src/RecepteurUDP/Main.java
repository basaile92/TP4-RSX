package RecepteurUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/**
 * @author Basile Dyment
 *
 */
public class Main {

        public static void main(String[] args) throws IOException {
        		int port;
        		InetAddress ad;
                byte[] buffer;
                DatagramPacket pack;
                DatagramSocket sock;
                ad = InetAddress.getByName("127.0.0.1");
                port = 3223;
                sock = new DatagramSocket(port);
                pack = new DatagramPacket(new byte[512], 512, ad, port);
                sock.send(pack);
                sock.receive(pack);
                buffer = pack.getData();
                System.out.println(new String(buffer));
                sock.close();
        }
}
