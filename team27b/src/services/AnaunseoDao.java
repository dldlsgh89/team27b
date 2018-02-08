package services;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class AnaunseoDao {
	
	public Connection driverdbcon() throws ClassNotFoundException, SQLException {
		System.out.println("드라이버로딩 및 db연결메서드 실행");
		Connection recon = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String jdbcDriver = "jdbc:mysql://localhost:3306/mysql;jjdev?" +
				"useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		
		DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		System.out.println(DriverManager.getConnection(jdbcDriver, dbUser, dbPass));
		
		return recon;
	}
	

}
