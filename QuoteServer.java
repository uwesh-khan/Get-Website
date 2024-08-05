import java.net.DatagramPacket;//	To create Datagram packets
import java.net.DatagramSocket;//	For UDP Server And UDP Client Implementation 
import java.io.IOException;
import java.net.InetAddress;

//NO STREAM HAS BEEN INVOLVED IN THIS COMMUNICATION BECAUSE OF PACKETS OVER THE INTERNET
public class QuoteServer{

public static void main(String [] args) throws IOException{

String quotes[] = {"THE TIME IS ALWAYS RIGHT TO DO WHAT IS RIGHT.\n \t\t MARTIN LUTHER KING,JR.","IF YOU WANT TO LIVE A HAPPY LIFE, TIE IT TO A GOAL, NOT TO PEOPLE OR THINGS. \n \t\t ALBERT EINSTEIN","THE BEST WAY TO PREDICT FUTURE IS TO CREATE IT.\n \t \t ABRAHAM LINCOLN","I believe every human has a finite number of heartbeats. I don't intend to waste any of mine.\ n \t \t 
Neil Armstrong","Never let the fear of striking out keep you from playing the game.”
\n \t \t Babe Ruth","I can accept failure, everyone fails at something. But I can’t accept not trying.”
\n \t \t Michael Jordan","Spread love everywhere you go. Let no one ever come without leaving happier.” \ n \t \t MOTHER TERESA"};

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






