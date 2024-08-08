import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;

import java.net.UnknownHostException;

public class URLConnectionTesting{

public static void main(String [] args)throws Exception{

URL url = new URL("http://www.thrivesup.com/careers.html");
URLConnection urlc = url.openConnection();

InputStream is = urlc.getInputStream();
OutputStream os = new FileOutputStream("d://thrivesup.html",true);

int ch = is.read();// byte by byte, returns int type
char chr;

while(ch!=-1){
chr=(char)ch;
os.write(chr);
ch=is.read();
}

is.close();

}
}