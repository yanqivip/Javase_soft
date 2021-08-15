	import java.awt.*;
	import javax.swing.*;
	
	public class QQLogin {
		public static void main(String args[]){
	
			JFrame w = new JFrame() ;
		
			w.setSize(250 , 125) ;
			
			//new组件
			JLabel labUser = new JLabel("用户名") ;
			JLabel labPass = new JLabel("密码") ;
			
			JTextField txtUser = new JTextField() ;
			JPasswordField txtPass = new JPasswordField() ;
			
			JButton btnLogin = new JButton("登陆") ;
			JButton btnReg = new JButton("注册") ;
			JButton btnCancel = new JButton("取消") ;
			
			//布置输入面板
			JPanel panInput = new JPanel() ;
			panInput.setLayout(new GridLayout(2 , 2)) ;
			
			panInput.add(labUser) ;
			panInput.add(txtUser) ;
			
			panInput.add(labPass) ;
			panInput.add(txtPass) ;
			
			//布置按钮面板
			JPanel panButton = new JPanel() ;
			panButton.setLayout(new FlowLayout()) ;
			
			panButton.add(btnLogin) ;
	 		panButton.add(btnReg) ;
	 		panButton.add(btnCancel) ;
	 		
	 		//布置窗体
	 		w.setLayout(new BorderLayout()) ;
	 		
	 		w.add(panInput , BorderLayout.CENTER) ;
	 		w.add(panButton , BorderLayout.SOUTH) ;
	 
			w.setVisible(true) ;
		}
	}