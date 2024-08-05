import java.net.DatagramSocket;// for client & server both
import java.net.DatagramPacket;// for packet creation
import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;
import java.net.InetAddress;
import java.util.Arrays;
import java.net.UnknownHostException;

public class UDPChatServer{

public static void main(String [] args)throws UnknownHostException, SocketException,IOException{
// Step 1:
DatagramSocket server = new DatagramSocket(4545);//	This is UDP Server
System.out.println("UDP server created!");

//Step 2: Create a byte array and pass it into constructor of DatagramPacket with its length

byte [] buffer = new byte[1024];
DatagramPacket emptyPacket = new DatagramPacket(buffer,buffer.length);

// Step 3: Create an infinite loop

server.receive(emptyPacket);	//	packets received from client

InetAddress ipAddress = emptyPacket.getAddress();//	Client1's IP
int port = emptyPacket.getPort(); //		Client1's port no

byte [] buffered = emptyPacket.getData(); // Data of client1

String str = new String(emptyPacket.getData());
System.out.println("Server received from C1 : "+str);// Done

byte [] buf = new byte[1024];
DatagramPacket packetC2 = new DatagramPacket(buf,buf.length);
server.receive(packetC2);

java.net.InetAddress ipAddress2 = packetC2.getAddress();// same system]
int por = packetC2.getPort();
DatagramPacket packetOfC2 = new DatagramPacket(buffered,buffered.length,ipAddress2,por);//Assuming client 2 same port

server.send(packetOfC2);	//	Server is sending datagram to its another client
System.out.println("Packet for second client has been sent!");

Arrays.fill(buffer,(byte)0);
Arrays.fill(buffered,(byte)0);


}}






