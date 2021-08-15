import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.* ;
import java.net.* ;
import java.awt.event.*;

public class QQMain extends JFrame implements ActionListener , Runnable, WindowListener{
	JTextField txtMess = new JTextField() ;
	JComboBox cmbUser = new JComboBox() ;
	JTextArea txtContent = new JTextArea() ;
	private Socket s ;
	public void setSocket(Socket value){
		s = value ;
		
		//启动线程
		Thread t = new Thread(this) ;
		t.start() ;
	}
	QQMain(){
		this.setSize(300 , 400) ;
		
		//new组件
		JButton btnSend = new JButton("发送") ;
		
		JScrollPane spContent = new JScrollPane(txtContent) ;
		
		//注册事件监听
		btnSend.addActionListener(this) ;
		this.addWindowListener(this) ;
		
		//布置小面板
		JPanel panSmall = new JPanel() ;
		panSmall.setLayout(new GridLayout(1 , 2)) ;
		
		panSmall.add(cmbUser) ;
		panSmall.add(btnSend) ;
		
		//布置大面板
		JPanel panBig = new JPanel() ;
		panBig.setLayout(new GridLayout(2 , 1)) ;
		
		panBig.add(txtMess) ;
		panBig.add(panSmall) ;
		
 		//布置窗体
		this.setLayout(new BorderLayout()) ;
		
		this.add(panBig , BorderLayout.NORTH) ;
		this.add(spContent , BorderLayout.CENTER) ;

		//读聊天记录
		try{
			File f = new File("c:/work/聊天记录.qq") ;
			
			FileReader fr = new FileReader(f) ;
			BufferedReader br = new BufferedReader(fr) ;
			
			while(br.ready()){
				txtContent.append(br.readLine()+"\n") ;
			}
		}catch(Exception e){}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// txtMess -------> txtContent
		txtContent.append(txtMess.getText()+"\n") ;
		
		// 将txtMess的内容存入聊天记录文件
		try{
			File f = new File("c:/work/聊天记录.qq") ;
			
			FileWriter fw = new FileWriter(f) ;
			PrintWriter pw = new PrintWriter(fw) ;
			
			pw.println(txtMess.getText()) ;
			
			pw.close() ;
		}catch(Exception e){}
		
		//发送信息到服务器
		try{
			OutputStream os = s.getOutputStream() ; 
			OutputStreamWriter osw = new OutputStreamWriter(os) ;
			PrintWriter pw = new PrintWriter(osw , true) ;
			
			pw.println(txtMess.getText()) ;
		}catch(Exception e){}

		// 清除txtMess中的内容
		txtMess.setText("") ;		
	}
	
	//接收线程
	public void run() {
		try{
			InputStream is = s.getInputStream() ;
			InputStreamReader isr = new InputStreamReader(is) ;
			BufferedReader br = new BufferedReader(isr) ;
			
			while(true){
				String message = br.readLine() ;
				String type = message.split("%")[0] ;
				String mess = message.split("%")[1] ;
				if(type.equals("add")){
					cmbUser.addItem(mess) ;
				}
				if(type.equals("exit")){
					cmbUser.removeItem(mess) ;
				}			}
		}catch(Exception e){}
	}

	/**
	 * Method windowOpened
	 *
	 *
	 * @param e
	 *
	 */
	public void windowOpened(WindowEvent e) {
		// TODO: Add your code here
	}

	/**
	 * Method windowClosing
	 *
	 *
	 * @param e
	 *
	 */
	public void windowClosing(WindowEvent e) {
		try{
			OutputStream os = s.getOutputStream() ;
			OutputStreamWriter osw = new OutputStreamWriter(os) ;
			PrintWriter pw = new PrintWriter(osw , true) ;
			
			pw.println("{exit}") ;

			//正常退出
			System.exit(0) ;
		}catch(Exception ex){}
	}

	/**
	 * Method windowClosed
	 *
	 *
	 * @param e
	 *
	 */
	public void windowClosed(WindowEvent e) {
		// TODO: Add your code here
	}

	/**
	 * Method windowIconified
	 *
	 *
	 * @param e
	 *
	 */
	public void windowIconified(WindowEvent e) {
		// TODO: Add your code here
	}

	/**
	 * Method windowDeiconified
	 *
	 *
	 * @param e
	 *
	 */
	public void windowDeiconified(WindowEvent e) {
		// TODO: Add your code here
	}

	/**
	 * Method windowActivated
	 *
	 *
	 * @param e
	 *
	 */
	public void windowActivated(WindowEvent e) {
		// TODO: Add your code here
	}

	/**
	 * Method windowDeactivated
	 *
	 *
	 * @param e
	 *
	 */
	public void windowDeactivated(WindowEvent e) {
		// TODO: Add your code here
	}
}