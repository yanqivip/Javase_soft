import javax.swing.table.TableModel;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.* ;

public class MyTableModel implements TableModel{
	private ResultSet rs = null ;
	private ResultSetMetaData rsmd = null;
	MyTableModel() {
		try {
			Connection cn = DataBase.getConnection("qq") ;
			Statement st = cn.createStatement() ;
			rs = st.executeQuery("select * from employee") ;
			rsmd = rs.getMetaData() ;
	    }
	    catch (Exception ex) {
	    }
	}
	public int getRowCount() {
		int count = 0 ;
		try {
			rs.last() ;
			count = rs.getRow() ;
	    }
	    catch (Exception ex) {
	    }
		return count ;
	}

	public int getColumnCount() {
		int count = 0 ;
		try {
			count = rsmd.getColumnCount() ;
	    }
	    catch (Exception ex) {
	    }
		return count ;
	}

	public String getColumnName(int columnIndex) {
		String name = null ;
		try {
			name = rsmd.getColumnName(columnIndex+1) ;
	    }
	    catch (Exception ex) {
	    }
		return name ;
	}

	public Class getColumnClass(int columnIndex) {
		return String.class ;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true ;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		String value = null ;
		try{
			rs.absolute(rowIndex+1) ;
			value = rs.getString(columnIndex+1) ;
			if(value!=null){
				value = new String(value.getBytes("ISO-8859-1") , "GB2312") ;
			}
		}catch(Exception e){}
		return value ;
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		try {
			Connection cn = DataBase.getConnection("qq");
			Statement st = cn.createStatement();
	
			String SQLStr = "update employee set " ;
			SQLStr += this.getColumnName(columnIndex);
			SQLStr += " = '" + aValue + "' where 1=1 ";
			for (int i = 0; i < this.getColumnCount(); i++) {
				if (this.getValueAt(rowIndex, i) != null) {
					SQLStr += " and " + this.getColumnName(i);
					SQLStr += " = '" + this.getValueAt(rowIndex, i) + "'";
				}
			}
	
			// 处理中文问题
			SQLStr = new String(SQLStr.getBytes("gb2312"), "ISO-8859-1");
			// 检查一下生成的SQL语句
			System.out.println(SQLStr);
	
			st.executeUpdate(SQLStr);
			rs = st.executeQuery("select * from employee");
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addTableModelListener(TableModelListener l) {
	}

	public void removeTableModelListener(TableModelListener l) {
	}
}