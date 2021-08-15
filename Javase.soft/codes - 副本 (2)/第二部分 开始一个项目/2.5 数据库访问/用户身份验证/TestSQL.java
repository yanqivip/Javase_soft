import java.sql.*;

public class TestSQL {
	public static void main(String args[]) {
		String u = "aaa";
		String p = "111";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306 					/qq","root", "123456");
			PreparedStatement ps = cn.prepareStatement("select * from user 					where username=? and password=?");
			ps.setString(1, u) ;
			ps.setString(2, p) ;
			rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("验证成功");
			} else {
				System.out.println("验证失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				cn.close();
			} catch (Exception e) {
			}
		}
	}
}