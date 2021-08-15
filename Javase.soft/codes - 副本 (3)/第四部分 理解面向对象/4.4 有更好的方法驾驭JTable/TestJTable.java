import java.awt.* ;
import javax.swing.* ;
import java.sql.* ;
import java.util.* ;

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
			
			int cols = rsmd.getColumnCount() ;
			//填充列名集合
			Vector columnName = new Vector() ;
			for (int i = 1; i<=cols; i++){
				columnName.add(rsmd.getColumnName(i)) ;
			}
			
			//填充数据集合
			Vector data = new Vector() ;
			while(rs.next()){
				//建立二维表
				Vector rowData = new Vector() ;
				for (int i = 1; i<= cols; i++){
					if(rs.getObject(i)!=null){
						rowData.add(new String(rs.getObject(i).toString().getBytes("ISO-8859-1") , "GB2312")) ;
					}
				}
				data.add(rowData) ;
			}
			
			//创建JTable
			JTable t = new JTable(data , columnName) ;	
			//不加滚动条表头显示不出来
			JScrollPane sp = new JScrollPane(t) ;	
			this.add(sp) ;
	    }
	    catch (Exception ex) {}
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