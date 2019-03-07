package other;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Jdbc {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	static {
		driver="com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/student1";
		user = "root";
		password = "453145";
	}

	/*
	 * 数据库连接
	 */
	public static Connection open() {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 数据库关闭
	 */
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
