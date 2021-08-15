import java.awt.* ;
import javax.swing.* ;
import java.sql.* ;

public class TestJTable extends JFrame {
	TestJTable() {
		this.setSize(400 , 300) ;
		
			Connection cn = null ;
			Statement st = null ;
			ResultSet rs = null ;
		try {
			cn = DataBase.getConnection("qq") ;
			
			st = cn.createStatement() ;
			rs = st.executeQuery("select * from employee") ;
			
			ResultSetMetaData rsmd = rs.getMetaData() ;
			
			rs.last() ;
			int rows = rs.getRow() ;
			
			int cols = rsmd.getColumnCount() ;
	
			//加一是为了多容纳一行列名
			JTable t = new JTable(rows+1 , cols) ;
			
			//显示列名
			for (int i = 0; i<cols; i++){
				t.setValueAt(rsmd.getColumnName(i+1) , 0 , i) ;
			}
			
			//显示内容
			rs.first() ;
			int row = 1 ;
			do{
				for (int i = 1; i<=6; i++){
					if(rs.getObject(i)!=null){
						t.setValueAt(new String(rs.getObject(i).toString().getBytes("ISO-8859-1") , "GB2312") , row , i-1) ;
					}
				}
				row ++ ;
			}while(rs.next()) ;
		
			this.add(t) ;
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
		TestJTable w = new TestJTable() ;
		w.setVisible(true) ;
	}
}