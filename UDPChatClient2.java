import java.util.Arrays;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.io.IOException;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class UDPChatClient2{

public static void main(String [] args)throws IOException,UnknownHostException{

DatagramSocket client2 = new DatagramSocket();//	This is UDPChatClient2

byte buffer [] = new byte[1024];
String str2 = new String("Welcome to the second client side!");
byte [] buff = str2.getBytes();
InetAddress address = InetAddress.getLocalHost();

DatagramPacket packet = new DatagramPacket(buff,buff.length,address,4545);
client2.send(packet);	//	packet send by server will be received by client
/*
byte buffer2 [] = new byte[1024];
InetAddress address = InetAddress.getLocalHost();// same system IP, UnknownHostException

DatagramPacket packet = new DatagramPacket(buffer,buffer.length,address,4545);// port no where the request is being sent

client2.send(packet);//	Packet means byte array!



client2.receive(packet2);// from server is the another client response

String received = new String(packet2.getData());//	Data of received packet!, getData() returns byte[]
System.out.println("Data of C1 for C2 : "+received);
*/

InetAddress address2 = InetAddress.getLocalHost();
int por = packet.getPort();
String receivedData = new String(packet.getData(),0,packet.getLength());
System.out.println("Ayan --->>> "+receivedData);
Scanner scanner = new Scanner(System.in);// console to java program!
System.out.print("Rehan --->>> ");
String str =  scanner.next();
byte [] buffer2 = str.getBytes();

DatagramPacket packet2 = new DatagramPacket(buffer2,buffer2.length,address2,por);	//	packet for receiving the server's packet!
client2.send(packet2);

Arrays.fill(buffer,(byte)0);
Arrays.fill(buffer2,(byte)0);


}

}