import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
//import java.io.OutputStreamReader;

public class EchooServer{

public static void main(String [] args)throws Exception{

ServerSocket server = new ServerSocket(5555);	//	Aargument type int

System.out.println("Server Started");

Socket client = null;

while(true){
client = server.accept();	//	Wait until the client response
talk(client);
}

}

public static void talk(Socket client) throws Exception{
// Given stream writes data from server to client
PrintWriter out = new PrintWriter(client.getOutputStream(),true);

// Given stream that reads the data from client to server
BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

String line = in.readLine();

while(line!=null){
System.out.println("Server received : "+line);
out.println(line+"...."+line);

if(line.equals("Bye")) break;
line=in.readLine();

}
}


}