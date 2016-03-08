package CreateDNS;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) throws IOException {

		int port;
		InetAddress ad;
        byte[] buffers = {0x08,(byte) 0xbb,0x01,0x00,
        		0x00, 0x01, 0x00, 0x00,
        		0x00, 0x00, 0x00, 0x00,
        		0x03, 0x77, 0x77, 0x77,
        		0x04, 0x6c, 0x69, 0x66,
        		0x6c, 0x02, 0x66, 0x72,
        		0x00,
        		0x00, 0x01,
        		0x00, 0x01
        };
        byte [] bufferr = new byte[512];
        DatagramPacket packs, packr;
        DatagramSocket sock;
        ad = InetAddress.getByName("8.8.8.8");
        port = 53;
        sock = new DatagramSocket(port);
        packs = new DatagramPacket(buffers , 512, ad, port);
        packr = new DatagramPacket(bufferr, 512);
        sock.send(packs);
        sock.receive(packr);
        System.out.println(new String(bufferr));
        sock.close();
        
	}

}
