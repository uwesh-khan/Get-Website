// PrintWriter is responsible to write data line by line!	,throws FileNotFoundException, To append the older data , "pass true in the argument of the constructor of PrintWriter"
// BufferedReader reads data line by line, Does not have String argument constructor ===> Follow decorated design pattern in constructor of BR to use Reader(AC) child's object (BufferedReader's object
// BufferedReader class method is readLine()  returns String, IOException, returns null at the end of the file
// To pass ONE object to another class constructor 	==> Decorated Design Pattern

import java.net.Socket;	//	for client implementation
import java.io.PrintWriter;	//	responsible to writer data line by line
import java.io.BufferedReader;	//	responsible to read data line by line
import java.io.InputStreamReader;
public class EchooClient{

public static void main(String []args) throws Exception{

// Servet3.0 internally uses Socket Programming to perform communication through Servlet and web browsers
Socket client = new Socket("localhost", 5555);// Socket = IP + Port number 

// BufferedReader(Reader,int) // BufferedReader(Reader)
PrintWriter out = null;
BufferedReader in = null;
BufferedReader br = null;

System.out.println("Echoo client started!....");

out = new PrintWriter(client.getOutputStream(),true);//	true to append the data in the file
in = new BufferedReader(new InputStreamReader(client.getInputStream()));
br = new BufferedReader(new InputStreamReader(System.in));

String input = br.readLine();//	returns line by line 
System.out.println(input);
while(!input.equals("Bye")){

out.println(input);
System.out.println(in.readLine());
input = br.readLine();
}

client.close();
out.close();
in.close();
br.close();


}
}