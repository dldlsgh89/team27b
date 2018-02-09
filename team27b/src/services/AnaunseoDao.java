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
	
	public ArrayList<Anaunseo> SelectAnaunseoList() {
		ArrayList<Anaunseo> ArrayAna = null;
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
			ArrayAna = new ArrayList<Anaunseo>();
			while(rs.next()) {									
			Anaunseo ana = new Anaunseo();
			   ana.setAnaunseoid(rs.getInt("anaunseo_id"));
			   ana.setAnaunseoname(rs.getString("anaunseo_name"));
			   ana.setAnaunseoage(rs.getInt("anaunseo_age"));	
			   
			   ArrayAna.add(ana);
			}
			
			

		}catch(SQLException sqlex){
			sqlex.getMessage();
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
}
