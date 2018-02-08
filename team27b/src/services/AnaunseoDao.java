package services;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;





public class AnaunseoDao {
	
	public ArrayList<Anaunseo> SelectAnaunseoList() {
		ArrayList<Anaunseo> ana = null;
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
			pstmt = conn.prepareStatement("select * from tb_member");
			//쿼리 실행 시작
			rs = pstmt.executeQuery();
			
			
			
			
		}catch(SQLException sqlex){
			sqlex.getMessage();
			sqlex.printStackTrace();
			
		} catch (ClassNotFoundException cnfe) {
			// 캐치는 하나안에 다 들어가지 못한다. 따로 나누어 써주어야한다
			cnfe.printStackTrace();
		}finally {
			
		}
		return ana;  //리턴 타입이 있으니 무조껀 return이 필요함 
	
	}
}
