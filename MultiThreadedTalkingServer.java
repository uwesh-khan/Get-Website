import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.io.InputStreamReader;


public class MultiThreadedTalkingServer extends Thread{//	TalkingServer accepts multiple response at a time because of multi-threading

private Socket client = null;// Global instance variable client to use inside methods

public MultiThreadedTalkingServer(Socket client){
this.client = client;	//	TO INITIALIZE THE client VARIABLE
}

@Override
public void run(){
try{
// out is responsible to writer data(Character) line by line
PrintWriter out = new PrintWriter(client.getOutputStream(),true);// true to append the previous content at the getOutputStream =>  to write output for client
BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));// get input from client
String line = in.readLine();
while(!line.equals("Bye")){
System.out.println("Server received : "+line);

out.println(line+"...."+line);
line=in.readLine();
}
}
catch(Exception e){
e.printStackTrace();
}
}// run close

public static void main(String [] args)throws IOException{

ServerSocket server = new ServerSocket(5555);
System.out.println("Server Started!");

boolean flag=true;
Socket client = null;
while(flag){
client=server.accept()	;// accept() waits for client request!

MultiThreadedTalkingServer myServer = new MultiThreadedTalkingServer(client);
myServer.start();//	Thread class method 
}

System.out.println("Multi_Threaded_Talking_Server Shutdown");
}





}