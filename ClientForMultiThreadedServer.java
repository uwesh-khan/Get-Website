import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.io.InputStreamReader;

public class ClientForMultiThreadedServer{
public static void main(String [] args)throws UnknownHostException, IOException{

Socket client = new Socket("localhost",5555);//	

PrintWriter out = null;
BufferedReader in = null;
BufferedReader br = null;

System.out.println("Client started for multi tasker server!");

out = new PrintWriter(client.getOutputStream(),true);// writer data from output stream
in = new BufferedReader(new InputStreamReader(client.getInputStream()));// read data from o/p str
br = new BufferedReader(new InputStreamReader(System.in));

String input = br.readLine();
System.out.println(input);

while(!input.equals("Bye")){

out.println(input);// client to server
System.out.println(in.readLine());// 
input = br.readLine();
}







}
}