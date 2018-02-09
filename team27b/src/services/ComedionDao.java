//27기 B조 이인호

package services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class ComedionDao {

	public ArrayList<Comedion> SelectComedionList() throws ClassNotFoundException{
		ArrayList<Comedion> ArrayCom = new ArrayList<Comedion>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("select comedion_id,comedion_name,comedion_age from comedion");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Comedion com = new Comedion();
				com.setComedionid(Integer.parseInt(rs.getString("comedion_id")));
				com.setComedionname(rs.getString("comedion_name"));
				com.setComedionage(rs.getInt("comedion_age"));
				
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
	
	
}
