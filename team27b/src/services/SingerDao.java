package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class SingerDao {
	// selectSingerList메서드 선언
	public ArrayList<Singer> selectSingerList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//Singer 배열을 만든다
		ArrayList<Singer> list = new ArrayList<Singer>();
		try {
			//드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			// DB연결관련 변수에 ip주소,포트번호,db명,dbid,dbpw값들을 담는다
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			// DB연결관련 변수에 담긴값들을 getConnection메서드를 통해 DB연결을 한 후 Connection객체를 생성하여 주소값을 리턴시킨다
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			// 리턴받은 주소값을 받아
			pstmt = conn.prepareStatement("SELECT * FROM singer");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Singer singer = new Singer();
				singer.setSingerId(rs.getInt("singer_id"));
				singer.setSingerName(rs.getString("singer_name"));
				singer.setSingerAge(rs.getInt("singer_age"));
				list.add(singer);
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
