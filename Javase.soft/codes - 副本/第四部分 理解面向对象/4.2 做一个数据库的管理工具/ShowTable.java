import java.sql.* ;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.*;
import java.util.* ;

	
public class ShowTable extends JFrame implements ActionListener, MouseListener {
	JComboBox cmbDatabase = new JComboBox() ;
	JList lstTable = new JList() ;
	ShowTable() {
		this.setSize(200 , 300) ;

		JScrollPane sp = new JScrollPane(lstTable) ;
		//注册事件
		cmbDatabase.addActionListener(this) ;
		lstTable.addMouseListener(this) ;
		
		this.setLayout(new BorderLayout()) ;
	
		this.add(cmbDatabase , BorderLayout.NORTH) ;
		this.add(sp , BorderLayout.CENTER) ;
	
		//添加数据库名字到下拉框中
		Connection cn = null ;
		Statement st = null ;
		ResultSet rs = null ;
		try {
			cn = DataBase.getConnection() ;
			st = cn.createStatement() ;
			rs = st.executeQuery("show Databases") ;
	
			while(rs.next()){
				cmbDatabase.addItem(rs.getString(1)) ;
			}
	    }catch (Exception ex) {}
		finally{
			try {
		   		rs.close() ;
			  	st.close() ;
			   	cn.close() ;
		    }
		    catch (Exception ex) {}
		}		
	}
	public static void main(String args[]){
		ShowTable w = new ShowTable() ;
		w.setVisible(true) ;
	}

	public void actionPerformed(ActionEvent e) {
		String database = (String)cmbDatabase.getSelectedItem() ;
		Connection cn = null ;
		Statement st = null ;
		ResultSet rs = null ;
		try {
			cn = DataBase.getConnection(database) ;
			st = cn.createStatement() ;
			rs = st.executeQuery("show tables") ;
			Vector v = new Vector() ;
			while(rs.next()){
				v.add(rs.getString(1)) ;
			}
			lstTable.setListData(v) ;
	    }catch (Exception ex) {}
		finally{
			try {
		   		rs.close() ;
			  	st.close() ;
			   	cn.close() ;
		    }catch (Exception ex) {}
		}		
	}

	/**
	 * Method mouseClicked
	 *
	 *
	 * @param e
	 *
	 */
	public void mouseClicked(MouseEvent e) {
		// TODO: Add your code here
	}

	/**
	 * Method mousePressed
	 *
	 *
	 * @param e
	 *
	 */
	public void mousePressed(MouseEvent e) {
		if(e.getClickCount()==2){//双击
			String database = cmbDatabase.getSelectedItem().toString() ;
			String table = lstTable.getSelectedValue().toString() ;
			int x = this.getX() ;
			int y = this.getY() ;
			int width = this.getWidth() ;
			int height = this.getHeight() ;
			ShowData w = new ShowData(database , table , x , y , width , height) ;
			w.setVisible(true) ;
		}
	}

	/**
	 * Method mouseReleased
	 *
	 *
	 * @param e
	 *
	 */
	public void mouseReleased(MouseEvent e) {
		// TODO: Add your code here
	}

	/**
	 * Method mouseEntered
	 *
	 *
	 * @param e
	 *
	 */
	public void mouseEntered(MouseEvent e) {
		// TODO: Add your code here
	}

	/**
	 * Method mouseExited
	 *
	 *
	 * @param e
	 *
	 */
	public void mouseExited(MouseEvent e) {
		// TODO: Add your code here
	}
}