package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataObjectHelper {
	
	private String userName="root";
	private String password="";
	
// 	we use local server 
	private String url="jdbc:mysql://localhost:3306/database";
	private static String driver="com.mysql.cj.jdbc.Driver";
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected Connection getConnection() {
		Connection connection=null;
		
		try {
			connection=DriverManager.getConnection(url,userName,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return connection;
		
	}
	
}
