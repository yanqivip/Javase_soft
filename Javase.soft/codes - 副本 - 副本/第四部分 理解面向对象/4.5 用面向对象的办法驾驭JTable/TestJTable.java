import java.awt.* ;
import javax.swing.* ;


public class TestJTable extends JFrame {
	TestJTable() {
		this.setSize(400 , 300) ;
	
			MyTableModel tm = new MyTableModel() ;
			//创建JTable
			JTable t = new JTable(tm) ;	
			//不加滚动条表头显示不出来
			JScrollPane sp = new JScrollPane(t) ;	
			this.add(sp) ;
	}
	public static void main(String args[]){
		TestJTable w = new TestJTable() ;
		w.setVisible(true) ;
	}
}