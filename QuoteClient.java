import java.net.InetAddress;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.io.IOException;

public class QuoteClient{
public static  void main(String [] args) throws IOException{//	SocketException is the child of IOException

DatagramSocket client = new DatagramSocket();	//	This is UDP client having NO ARGUMENT CONSTRUCTOR

byte[] buffer = new byte[1024];
InetAddress address = InetAddress.getByName("localhost");//	Returns the IP Address, UnknownHostException

DatagramPacket packet = new DatagramPacket(buffer,buffer.length,address,5555);
client.send(packet);

packet = new DatagramPacket(buffer,buffer.length);//	byte array to receive packet
client.receive(packet);//	PACKETS = BYTE ARRAY

String received = new String(packet.getData());// data from server's packet
System.out.println(received);
client.close();


}
}