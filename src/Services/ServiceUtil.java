package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServiceUtil {

	
	public Connection getConn() {
		Connection conn=null;
		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system", "123456");
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/world?"
			                + "user=root&password=123456&useUnicode=true&characterEncoding=UTF8";
				 conn= DriverManager.getConnection(url);
				return conn;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
				System.out.println("获取conn失败，conn为null！注意..");
				return conn;
	}
}
