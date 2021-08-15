import java.net.*;
import java.io.*;

public class QQServer {
	public static void main(String[] args) {
		try{
			//服务器在8000端口监听
			ServerSocket ss = new ServerSocket(8000) ;
		
			System.out.println("服务器正在8000端口监听......") ;
			Socket s = ss.accept() ;
			
			//接受用户名和密码
			InputStream is = s.getInputStream() ;
			InputStreamReader isr = new InputStreamReader(is) ;
			BufferedReader br = new BufferedReader(isr) ;
		
			String uandp = br.readLine() ;
			
			//拆分用户名和密码
			String u = uandp.split("%")[0] ;
			String p = uandp.split("%")[1] ;

			OutputStream os = s.getOutputStream() ;
			OutputStreamWriter osw = new OutputStreamWriter(os) ;
			PrintWriter pw = new PrintWriter(osw , true) ;
	
			if(u.equals("aaa")&&p.equals("111")){
				//发送正确信息到客户端
				pw.println("ok") ;

				//不断地接收客户端发送过来的信息
				while (true) {
					String message = br.readLine();
					System.out.println(message);
				}
			}else {
				//发送错误信息到客户端
				pw.println("err") ;
			}	
		}catch(Exception e){}
	}
}