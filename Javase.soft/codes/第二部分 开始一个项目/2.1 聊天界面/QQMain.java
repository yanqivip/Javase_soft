import javax.swing.*;
import java.awt.*;

public class QQMain {
	public static void main(String args[]){
		JFrame w = new JFrame() ;
		
		w.setSize(300 , 400) ;
		
		//new组件
		JTextField txtMess = new JTextField() ;
		
		JComboBox cmbUser = new JComboBox() ;
		JButton btnSend = new JButton("发送") ;
		
		JTextArea txtContent = new JTextArea() ;
		//设置滚动条
		JScrollPane spContent = new JScrollPane(txtContent) ;
		
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
		w.setLayout(new BorderLayout()) ;
		
		w.add(panBig , BorderLayout.NORTH) ;
		w.add(spContent , BorderLayout.CENTER) ;

		w.setVisible(true) ;
	}
}