import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
public class Chrome_As_A_TCPClient{

public static void main(String [] args) throws UnknownHostException,IOException {


Socket client = new Socket("localhost",4444);	//	ipofserver,portnumber
System.out.println("client created successfully!");






}
}