import java.net.*;
import java.io.*;

public class MyClient {
	public static void main(String[] args) {
		try{
			Socket s = new Socket("localhost" , 8000) ;
			
			OutputStream os = s.getOutputStream() ;
			OutputStreamWriter osw = new OutputStreamWriter(os) ;
			PrintWriter pw = new PrintWriter(osw,true) ;
			
			pw.println("Õı—Û") ;
			
			InputStream is = s.getInputStream() ;
			InputStreamReader isr = new InputStreamReader(is) ;
			BufferedReader br = new BufferedReader(isr) ;
			
			String mess = br.readLine() ;
			System.out.println(mess) ;
		}catch(Exception e){}
	}
}