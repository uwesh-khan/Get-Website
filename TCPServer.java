import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
public class TCPServer{

public static void main(String [] args)throws IOException{

ServerSocket server = new ServerSocket(4444);
/**
Server has been bound  with local port (Server port) i.e., 4444 manually
*/

System.out.println("TCP Server started successfully!");
System.out.println("TCP Server is now ready to accept client request........");
Socket client = server.accept();

System.out.println(client);
System.out.println("Server shutdown successfully!");



}
}