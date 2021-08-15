import java.sql.*;

public class TestSQL {
	public static void main(String args[]) {
		Connection cn = null ;
		Statement st = null ;
		ResultSet rs = null ;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qq", "root", "123456");
			st = cn.createStatement() ;
			rs = st.executeQuery("select * from employee") ;
			while(rs.next()){
				System.out.println(rs.getString(2)) ;
			}
 		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try{
				rs.close() ;
				st.close() ;
				cn.close() ;
			}catch(Exception e){}
		}
	}
}