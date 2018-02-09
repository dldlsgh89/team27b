//27기 B조 이인호

package services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import org.apache.catalina.connector.Request;

public class ComedianDao {

	public ArrayList<Comedian> selectComedianList(){
		ArrayList<Comedian> ArrayCom = new ArrayList<Comedian>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("select comedian_id,comedian_name,comedian_age from comedian");
			//select+ORDER BY+ASC내림차순?? 
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Comedian com = new Comedian();
				com.setComedianid(Integer.parseInt(rs.getString("comedian_id")));
				com.setComedianname(rs.getString("comedian_name"));
				com.setComedianage(rs.getInt("comedian_age"));
				
				ArrayCom.add(com);
			}
			
		}catch(ClassNotFoundException cnfe){
			cnfe.getMessage();
		}catch(SQLException sqle) {	
			sqle.printStackTrace();
		}finally {
			if(rs != null) try{rs.close();} catch(SQLException sqle) {}
			if(pstmt != null) try{pstmt.close();} catch(SQLException sqle) {}
			if(conn != null) try{conn.close();}  catch(SQLException sqle) {}
		}
		
		
		return ArrayCom;
		
	}
	
	public void insertComedian() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("insert into comedian values (0,'?','?') ");
			
			pstmt.setString(1, "comedian_id");
			pstmt.setString(2, "comedian_name");
			pstmt.setString(3, "comedian_age");
			
			pstmt.executeUpdate();
			
			
		}catch(ClassNotFoundException cnfex){
			cnfex.printStackTrace();
		}catch(SQLException sqle) {	
			sqle.printStackTrace();
		}finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException sqle) {}
			if(conn != null) try {conn.close();} catch(SQLException sqle) {}
		}
		
		
	}
	
	
}
