import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.io.IOException;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class UDPChatClient{

public static void main(String [] args)throws UnknownHostException,IOException{

DatagramSocket client = new DatagramSocket();//	This is UDPChatClient
Scanner scanner = new Scanner(System.in);// java program to console!
System.out.println("Let's embrace chat with someone!...");



String str =  scanner.next();
byte buffer [] = new byte[1024];
buffer = str.getBytes();

InetAddress address = InetAddress.getLocalHost();// same system IP

DatagramPacket packet = new DatagramPacket(buffer,buffer.length,address,4545);// port no where the request is being sent

client.send(packet);//	Packet means byte array!
packet = new DatagramPacket(buffer,buffer.length);	//	packet for receiving the server's packet!

client.receive(packet);// from server is the another client response
String received = new String(packet.getData());//	Data of received packet!
System.out.println(received);
client.close();

}

}