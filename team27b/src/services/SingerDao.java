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
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
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
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			// 리턴받은 주소값을 받아 Connection객체에 들어간 후 쿼리실행 준비메서드를 실행하고 statement객체를 새로 생성 후 그 주소값을 리턴시켜 pstmt 참조변수에 담는다
			preparedStatement = connection.prepareStatement("SELECT singer_id,singer_name,singer_age FROM singer ORDER BY singer_id ASC");
			// 리턴받은 주소값을 받아 statement객체에 들어간 후 쿼리실행을 하고 ResultSet객체를 생성하여 쿼리 실행 결과를 데이터영역에 담고 생성된 주소값을 리턴하여 rs 참조변수에 담는다
			resultSet = preparedStatement.executeQuery();
			// 리턴받은 주소값을 받아 ResultSet객체내 next메서드를 호출하여 데이터영역에 한줄 한줄 데이터존재 유무를 읽어 오고 존재하면 true값을 리턴하고
			//존재하지 않으면 false값을 리턴한다 while 반복문은 조건이 참일경우 블록내 명령문을 반복실행하고 거짓일때 반복을 멈추고 다음 실행 단계로 넘긴다
			while(resultSet.next()) {
				// Singer객체를 생성하여 DB에서 가져온데이터를 객체내에 저장하고 list에 저장한다
				Singer singer = new Singer();
				singer.setSingerId(resultSet.getInt("singer_id"));
				singer.setSingerName(resultSet.getString("singer_name"));
				singer.setSingerAge(resultSet.getInt("singer_age"));
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
			if(resultSet == null) try {resultSet.close();}catch(SQLException ex){}
			if(preparedStatement == null) try {resultSet.close();}catch(SQLException ex){}
			if(connection == null) try {resultSet.close();}catch(SQLException ex){}
		}
		// Singer 배열 주소값을 리턴시킨다
		return list;
	}
	
	public void insertSinger(Singer singer) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedStatement = connection.prepareStatement("insert into singer values (0, ?, ?)");
			
			preparedStatement.setString(1, singer.getSingerName());
			preparedStatement.setInt(2, singer.getSingerAge());
			
			preparedStatement.executeUpdate();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally { 
			if (preparedStatement != null) try { preparedStatement.close(); } catch(SQLException ex) {} 
			if (connection != null) try { connection.close(); } catch(SQLException ex) {} 
		}
	}
	
	public void deleteSinger(int singerId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedStatement = connection.prepareStatement("DELETE FROM singer WHERE singer_id=?");
			
			preparedStatement.setInt(1, singerId);			
			
			preparedStatement.executeUpdate();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if (preparedStatement != null) try { preparedStatement.close(); } catch(SQLException ex) {} 
			if (connection != null) try { connection.close(); } catch(SQLException ex) {} 
		}
	}
	//
	public Singer updateFormSinger(int singerId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Singer singer = new Singer();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedStatement = connection.prepareStatement("SELECT singer_id,singer_name,singer_age FROM singer WHERE singer_id=?");
			preparedStatement.setInt(1, singerId);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				singer.setSingerId(resultSet.getInt("singer_id"));
				singer.setSingerName(resultSet.getString("singer_name"));
				singer.setSingerAge(resultSet.getInt("singer_age"));
			}
			
		}catch(ClassNotFoundException cnfe){
			cnfe.getMessage();
		}catch(SQLException sqle) {	
			sqle.printStackTrace();
		}finally {
			if(resultSet != null) try{resultSet.close();} catch(SQLException sqle) {}
			if(preparedStatement != null) try{preparedStatement.close();} catch(SQLException sqle) {}
			if(connection != null) try{connection.close();}  catch(SQLException sqle) {}
		}
		
		return singer;
	}
	
	public void updateActionSinger(Singer singer) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedStatement = connection.prepareStatement("UPDATE singer SET singer_name=?, singer_age=? WHERE singer_id=?");
			preparedStatement.setString(1, singer.getSingerName());
			preparedStatement.setInt(2, singer.getSingerAge());
			preparedStatement.setInt(3, singer.getSingerId());
			
			preparedStatement.executeUpdate();
			
		}catch(ClassNotFoundException cnfe){
			cnfe.getMessage();
		}catch(SQLException sqle) {	
			sqle.printStackTrace();
		}finally {
			if(preparedStatement != null) try{preparedStatement.close();} catch(SQLException sqle) {}
			if(connection != null) try{connection.close();}  catch(SQLException sqle) {}
		}
			
	}
}
