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
	
	public void comedianUpdateAction(int comedianid, String comedianname,int comedianage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("update comedian set comedian_name=?,comedian_age=? where comedian_id=?");
			pstmt.setString(1, comedianname);
			pstmt.setInt(2, comedianage);
			pstmt.setInt(3, comedianid);		
			
			pstmt.executeUpdate();
			
			
		}catch(ClassNotFoundException cnfex){
			cnfex.printStackTrace();
		}catch(SQLException sqle) {	
			sqle.printStackTrace();
		}finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException es) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException es) {}
		}
	}
	
	public Comedian comedianUpdateForm(int ComedianId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Comedian com = new Comedian();
		try {		
			Class.forName("com.mysql.jdbc.Driver");		
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);	
			pstmt = conn.prepareStatement("select * from comedian where comedian_id = ?");		
			pstmt.setInt(1, ComedianId);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {		
			   com.setComedianId(rs.getInt("comedian_id"));;
			   com.setComedianName(rs.getString("comedian_name"));
			   com.setComedianAge(rs.getInt("comedian_age"));;	
			}			
		}catch(SQLException sqlex){
			sqlex.getMessage(); //어떻게 출력된다고 했었는데 기억이 안난다
			sqlex.printStackTrace();
			
		} catch (ClassNotFoundException cnfe) {
			// 캐치는 하나안에 다 들어가지 못한다. 따로 나누어 써주어야한다
			cnfe.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException sqlex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException sqlex) {}
			if(conn != null) try {conn.close();} catch(SQLException sqlex) {}
		}
		return com;		
	}
	
	public void deleteComedianList(int ComedianId){
		Connection conn = null;
		PreparedStatement pstmt = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
				
				pstmt = conn.prepareStatement("delete from comedian where comedian_id = ?");
				pstmt.setInt(1, ComedianId);
				
				pstmt.executeUpdate();
			}catch(SQLException ex){
				ex.printStackTrace();
			}catch(ClassNotFoundException cnfe){
				cnfe.printStackTrace();
			}finally{
				if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
				if(conn != null) try {conn.close();} catch(SQLException ex) {}
			}
	}

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
				com.setComedianId(Integer.parseInt(rs.getString("comedian_id")));
				com.setComedianName(rs.getString("comedian_name"));
				com.setComedianAge(rs.getInt("comedian_age"));
				
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
	
	public void insertComedian(Comedian com) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("insert into comedian values (0, ?, ?)");
			
			
			pstmt.setString(1, com.getComedianName());
			pstmt.setInt(2, com.getComedianAge());
			
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
