//나성수

package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class SingerDao {
	/*
	 * selectSingerList메서드 선언
	 * DB에 들어있는 가수데이터 전체리스트를 뽑아주는 메서드이다
	 */
	public ArrayList<Singer> selectSingerList() {
		/*
		 * jdbc관련 참조변수를 선언한다
		 * DB를 사용하기위해 필요한 변수들이다
		 */
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		/*
		 * Singer 배열을 만든다
		 * 여러명의 가수데이터를 담을 공간을 만들어준다
		 */
		ArrayList<Singer> arraySinger = new ArrayList<Singer>();
		try {
			/*드라이버 로딩*/
			Class.forName("com.mysql.jdbc.Driver");
			/*
			 * DB연결관련 변수에 ip주소,포트번호,db명,dbid,dbpw값들을 담는다
			 * 주소와 아이디 패스워드가 일치해야만 DB를 사용할수가 있다
			 */
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			// DB연결관련 변수에 담긴값들을 getConnection메서드를 통해 DB연결을 한 후 Connection객체를 생성하여 주소값을 리턴시켜 conn 참조변수에 담는다
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			// 리턴받은 주소값을 받아 Connection객체에 들어간 후 쿼리실행 준비메서드를 실행하고 statement객체를 새로 생성 후 그 주소값을 리턴시켜 pstmt 참조변수에 담는다
			preparedstatement = connection.prepareStatement("SELECT singer_id,singer_name,singer_age FROM singer ORDER BY singer_id ASC");
			// 리턴받은 주소값을 받아 statement객체에 들어간 후 쿼리실행을 하고 ResultSet객체를 생성하여 쿼리 실행 결과를 데이터영역에 담고 생성된 주소값을 리턴하여 rs 참조변수에 담는다
			resultset = preparedstatement.executeQuery();
			// 리턴받은 주소값을 받아 ResultSet객체내 next메서드를 호출하여 데이터영역에 한줄 한줄 데이터존재 유무를 읽어 오고 존재하면 true값을 리턴하고
			//존재하지 않으면 false값을 리턴한다 while 반복문은 조건이 참일경우 블록내 명령문을 반복실행하고 거짓일때 반복을 멈추고 다음 실행 단계로 넘긴다
			while(resultset.next()) {
				// Singer객체를 생성하여 DB에서 가져온데이터를 객체내에 저장하고 list에 저장한다
				Singer singer = new Singer();
				singer.setSingerId(resultset.getInt("singer_id"));
				singer.setSingerName(resultset.getString("singer_name"));
				singer.setSingerAge(resultset.getInt("singer_age"));
				arraySinger.add(singer);
			}
		// jdbc관련 예외발생시 catch부분으로 넘겨 처리한다
		}catch(SQLException sqlex) {
			// 예외발생된 java문구를 알려준다
			sqlex.getStackTrace();
			// 예외발생된 이유를 알려준다
			System.out.println(sqlex.getMessage());
		// Class.forName관려 예외발생시 catch부분으로 넘겨 처리한다
		} catch (ClassNotFoundException classex) {
			classex.printStackTrace();
			System.out.println(classex.getMessage());
		}finally {
			// 사용한 객체들을 정리해준다
			if(resultset == null) try {resultset.close();}catch(SQLException sqlex){}
			if(preparedstatement == null) try {resultset.close();}catch(SQLException sqlex){}
			if(connection == null) try {resultset.close();}catch(SQLException sqlex){}
		}
		// Singer 배열 주소값을 리턴시킨다
		return arraySinger;
	}
	
	public void insertSinger(String singerName,int singerAge) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement("insert into singer values (0, ?, ?)");
			
			preparedstatement.setString(1, singerName);
			preparedstatement.setInt(2, singerAge);
			
			preparedstatement.executeUpdate();
			
		}catch(ClassNotFoundException classex) {
			classex.printStackTrace();
		} catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}finally { 
			if (preparedstatement != null) try { preparedstatement.close(); } catch(SQLException sqlex) {} 
			if (connection != null) try { connection.close(); } catch(SQLException sqlex) {} 
		}
	}
	
	public void deleteSinger(int singerId) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement("DELETE FROM singer WHERE singer_id=?");
			
			preparedstatement.setInt(1, singerId);			
			
			preparedstatement.executeUpdate();
			
		}catch(ClassNotFoundException classex) {
			classex.printStackTrace();
		} catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}finally {
			if (preparedstatement != null) try { preparedstatement.close(); } catch(SQLException sqlex) {} 
			if (connection != null) try { connection.close(); } catch(SQLException sqlex) {} 
		}
	}
	//
	public Singer updateSingerForm(int singerId) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		Singer singer = new Singer();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedstatement = connection.prepareStatement("SELECT singer_id,singer_name,singer_age FROM singer WHERE singer_id=?");
			preparedstatement.setInt(1, singerId);
			
			resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				singer.setSingerId(resultset.getInt("singer_id"));
				singer.setSingerName(resultset.getString("singer_name"));
				singer.setSingerAge(resultset.getInt("singer_age"));
			}
			
		}catch(ClassNotFoundException classex){
			classex.getMessage();
		}catch(SQLException sqlex) {	
			sqlex.printStackTrace();
		}finally {
			if(resultset != null) try{resultset.close();} catch(SQLException sqle) {}
			if(preparedstatement != null) try{preparedstatement.close();} catch(SQLException sqlex) {}
			if(connection != null) try{connection.close();}  catch(SQLException sqlex) {}
		}
		
		return singer;
	}
	
	public void updateSingerAction(int singerId,String singerName,int singerAge) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedstatement = connection.prepareStatement("UPDATE singer SET singer_name=?, singer_age=? WHERE singer_id=?");
			preparedstatement.setString(1, singerName);
			preparedstatement.setInt(2, singerAge);
			preparedstatement.setInt(3, singerId);
			
			preparedstatement.executeUpdate();
			
		}catch(ClassNotFoundException classex){
			classex.getMessage();
		}catch(SQLException sqlex) {	
			sqlex.printStackTrace();
		}finally {
			if(preparedstatement != null) try{preparedstatement.close();} catch(SQLException sqlex) {}
			if(connection != null) try{connection.close();}  catch(SQLException sqlex) {}
		}
			
	}
}
