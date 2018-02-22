//27기 B조 이인호

package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import services.Anaunseo;

public class AnaunseoDao {
	
	public void anaunseoUpdateAction(int anaunseoid, String anaunseoname,int anaunseoage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("update anaunseo set anaunseo_name=?,anaunseo_age=? where anaunseo_id=?");
			pstmt.setString(1, anaunseoname);
			pstmt.setInt(2, anaunseoage);
			pstmt.setInt(3, anaunseoid);		
			
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
	
	public Anaunseo anaunseoUpdateForm(int AnaunseoId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Anaunseo ana = new Anaunseo();
		try {		
			Class.forName("com.mysql.jdbc.Driver");		
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);	
			pstmt = conn.prepareStatement("select * from anaunseo where anaunseo_id = ?");		
			pstmt.setInt(1, AnaunseoId);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {		
			   ana.setAnaunseoId(rs.getInt("anaunseo_id"));
			   ana.setAnaunseoName(rs.getString("anaunseo_name"));
			   ana.setAnaunseoAge(rs.getInt("anaunseo_age"));	
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
		return ana;		
	}
	
	public void deleteAnaunseoList(int AnaunseoId){
		Connection conn = null;
		PreparedStatement pstmt = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
				
				pstmt = conn.prepareStatement("delete from anaunseo where anaunseo_id = ?");
				pstmt.setInt(1, AnaunseoId);
				
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
	
	
	public ArrayList<Anaunseo> selectAnaunseoList() {
		ArrayList<Anaunseo> ArrayAna = new ArrayList<Anaunseo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//드라이브 로딩
			Class.forName("com.mysql.jdbc.Driver");
			//db연결
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			//쿼리 실행 준비
			pstmt = conn.prepareStatement("select anaunseo_id,anaunseo_name,anaunseo_age from anaunseo");
										//// anaunseo_id as anaunseoid = 컬럼명 anaunseo_id을 anaunseoid 바꾼다 as나 ""는 생략이 가능하다
			
			//쿼리 실행 시작
			rs = pstmt.executeQuery();
		
//while문을 통해 준비된 쿼리문장을 실행하고 값을 받아서 값이 나오지 않을때까지 반복하는 메서드를 만든후 
//select 쿼리문장으로 검색된 각 컬럼값들을 받아 anaunseo클래스 타입의 어레이리스트 객체를 만들어 참조값을 담은 ana Dto에 셋팅한다?
			while(rs.next()) {									
			Anaunseo ana = new Anaunseo();
			   ana.setAnaunseoId(rs.getInt("anaunseo_id"));
			   ana.setAnaunseoName(rs.getString("anaunseo_name"));
			   ana.setAnaunseoAge(rs.getInt("anaunseo_age"));	
			   ArrayAna.add(ana);
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
		return ArrayAna;  //리턴 타입이 있으니 무조껀 return이 필요함 
	
	}
	
	public void insertAnaunseo(Anaunseo ana) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("insert into anaunseo values (0, ?, ?)");
			
			
			pstmt.setString(1, ana.getAnaunseoName());
			pstmt.setInt(2, ana.getAnaunseoAge());
			
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
