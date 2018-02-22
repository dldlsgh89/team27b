//나성수

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
		// jdbc관련 참조변수를 선언한다
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
			// DB연결관련 변수에 담긴값들을 getConnection메서드를 통해 DB연결을 한 후 Connection객체를 생성하여 주소값을 리턴시켜 conn 참조변수에 담는다
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			// 리턴받은 주소값을 받아 Connection객체에 들어간 후 쿼리실행 준비메서드를 실행하고 statement객체를 새로 생성 후 그 주소값을 리턴시켜 pstmt 참조변수에 담는다
			pstmt = conn.prepareStatement("SELECT singer_id,singer_name,singer_age FROM singer ORDER BY singer_id ASC");
			// 리턴받은 주소값을 받아 statement객체에 들어간 후 쿼리실행을 하고 ResultSet객체를 생성하여 쿼리 실행 결과를 데이터영역에 담고 생성된 주소값을 리턴하여 rs 참조변수에 담는다
			rs = pstmt.executeQuery();
			// 리턴받은 주소값을 받아 ResultSet객체내 next메서드를 호출하여 데이터영역에 한줄 한줄 데이터존재 유무를 읽어 오고 존재하면 true값을 리턴하고
			//존재하지 않으면 false값을 리턴한다 while 반복문은 조건이 참일경우 블록내 명령문을 반복실행하고 거짓일때 반복을 멈추고 다음 실행 단계로 넘긴다
			while(rs.next()) {
				// Singer객체를 생성하여 DB에서 가져온데이터를 객체내에 저장하고 list에 저장한다
				Singer singer = new Singer();
				singer.setSingerId(rs.getInt("singer_id"));
				singer.setSingerName(rs.getString("singer_name"));
				singer.setSingerAge(rs.getInt("singer_age"));
				list.add(singer);
			}
		// jdbc관련 예외발생시 catch부분으로 넘겨 처리한다
		}catch(SQLException ex) {
			// 예외발생된 java문구를 알려준다
			ex.getStackTrace();
			// 예외발생된 이유를 알려준다
			System.out.println(ex.getMessage());
		// Class.forName관려 예외발생시 catch부분으로 넘겨 처리한다
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			// 사용한 객체들을 정리해준다
			if(rs == null) try {rs.close();}catch(SQLException ex){}
			if(pstmt == null) try {rs.close();}catch(SQLException ex){}
			if(conn == null) try {rs.close();}catch(SQLException ex){}
		}
		// Singer 배열 주소값을 리턴시킨다
		return list;
	}
	
	public void insertSinger(Singer singer) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&charaterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement("insert into singer values (0, ?, ?)");
			
			preparedstatement.setString(1, singer.getSingerName());
			preparedstatement.setInt(2, singer.getSingerAge());
			
			preparedstatement.executeUpdate();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally { 
			if (preparedstatement != null) try { preparedstatement.close(); } catch(SQLException ex) {} 
			if (connection != null) try { connection.close(); } catch(SQLException ex) {} 
		}
	}
}
