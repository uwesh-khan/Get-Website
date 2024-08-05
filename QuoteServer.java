import java.net.DatagramPacket;//	To create Datagram packets
import java.net.DatagramSocket;//	For UDP Server And UDP Client Implementation 
import java.io.IOException;
import java.net.InetAddress;

//NO STREAM HAS BEEN INVOLVED IN THIS COMMUNICATION BECAUSE OF PACKETS OVER THE INTERNET
public class QuoteServer{

public static void main(String [] args) throws IOException{

String quotes[] = {"Padh le!....","Dusro ko bhi padne de!...","Apna pad!...","Chal ja yrr!...","A tu ja re!...","Kem Palty","chal ja!...","Bhag be yaha se!..."};

// Step 1: Create a UDP Server, datagram means packets
DatagramSocket server = new DatagramSocket(5555);// This  is UDP Server, INT PARAMETERIZED CONSTRUCTOR, socketexception
System.out.println("UDP Server created!");

// Step 2: Create a Byte Array and pass it into DatagramPacket constructor argument with array length

byte [] buffer = new byte[1024];//	Array of any size

DatagramPacket emptyPacket = new DatagramPacket(buffer, buffer.length);//	 For making data packet
//packets: A small segment of a larger message. or  A user sends an email, and the email client breaks the message into data packets before
//  sending them over the internet to the recipient's email server.

// Step 3: Create an infinite loop - To receive packets inifinitely
while(true){
server.receive(emptyPacket);// receive() receives the packet from the client over the internet, IOException, retrns void 

InetAddress address = emptyPacket.getAddress();//	IP of packet or IP of client
int port = emptyPacket.getPort();//	 port no of client or whether the packets are being sent from

double random = Math.random() * 6;	//	To select quote randomly!
int i = (int)random;	//	Will remove precision value
String q = quotes[i];	//	Initializing the selected random quote
byte[] quoteBuffer = q.getBytes();//	Bytes of selected QUOTE

DatagramPacket packet = new DatagramPacket(quoteBuffer, quoteBuffer.length,address,port);	//	packet send by the server in response of client's packet

server.send(packet);	// sending packet to client, IOException, returns void 

}

}

}






