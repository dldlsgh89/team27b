package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RapperDao {
	
	public ArrayList<Repper> selectSingerList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Repper> list = new ArrayList<Repper>();
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("SELECT * FROM repper");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Repper repper = new Repper();
				repper.setRepperId(rs.getInt("repper_id"));
				repper.setRepperName(rs.getString("repper_name"));
				repper.setRepperAge(rs.getInt("repper_age"));
				list.add(repper);
			}
		}catch(SQLException ex) {
			ex.getStackTrace();
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			if(rs == null) try {rs.close();}catch(SQLException ex){}
			if(pstmt == null) try {rs.close();}catch(SQLException ex){}
			if(conn == null) try {rs.close();}catch(SQLException ex){}
		}
		
		return list;
	}
}
