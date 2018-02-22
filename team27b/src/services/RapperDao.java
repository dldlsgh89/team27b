//나성수

package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RapperDao {
	// selectRapperList메서드 선언
	public ArrayList<Rapper> selectRapperList() {
		// jdbc관련 참조변수를 선언한다
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//Rapper 배열을 만든다
		ArrayList<Rapper> list = new ArrayList<Rapper>();
		try {
			// 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			// DB연결관련 변수에 ip주소,포트번호,db명,dbid,dbpw값들을 담는다
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedStatement = connection.prepareStatement("SELECT rapper_id,rapper_name,rapper_age FROM rapper");
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Rapper rapper = new Rapper();
				rapper.setRapperId(resultSet.getInt("rapper_id"));
				rapper.setRapperName(resultSet.getString("rapper_name"));
				rapper.setRapperAge(resultSet.getInt("rapper_age"));
				list.add(rapper);
			}
		}catch(SQLException ex) {
			ex.getStackTrace();
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			if(resultSet == null) try {resultSet.close();}catch(SQLException ex){}
			if(preparedStatement == null) try {resultSet.close();}catch(SQLException ex){}
			if(connection == null) try {resultSet.close();}catch(SQLException ex){}
		}
		
		return list;
	}
	
	public void insertRapper(Rapper rapper) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedStatement = connection.prepareStatement("insert into rapper values (0, ?, ?)");
			
			preparedStatement.setString(1, rapper.getRapperName());
			preparedStatement.setInt(2, rapper.getRapperAge());
			
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
	
	public void deleteRapper(int rapperId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedStatement = connection.prepareStatement("DELETE FROM rapper WHERE rapper_id=?");
			
			preparedStatement.setInt(1, rapperId);			
			
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
	
	public Rapper updateFormRapper(int rapperId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		Rapper rapper = new Rapper();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedStatement = connection.prepareStatement("SELECT rapper_id,rapper_name,rapper_age FROM rapper WHERE rapper_id=?");
			preparedStatement.setInt(1, rapperId);
			
			resultset = preparedStatement.executeQuery();
			
			if(resultset.next()) {
				rapper.setRapperId(resultset.getInt("rapper_id"));
				rapper.setRapperName(resultset.getString("rapper_name"));
				rapper.setRapperAge(resultset.getInt("rapper_age"));
			}
			
		}catch(ClassNotFoundException cnfe){
			cnfe.getMessage();
		}catch(SQLException sqle) {	
			sqle.printStackTrace();
		}finally {
			if(resultset != null) try{resultset.close();} catch(SQLException sqle) {}
			if(preparedStatement != null) try{preparedStatement.close();} catch(SQLException sqle) {}
			if(connection != null) try{connection.close();}  catch(SQLException sqle) {}
		}
		
		return rapper;
	}
	
	public void updateActionRapper(Rapper rapper) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedStatement = connection.prepareStatement("UPDATE rapper SET rapper_name=?, rapper_age=? WHERE rapper_id=?");
			preparedStatement.setString(1, rapper.getRapperName());
			preparedStatement.setInt(2, rapper.getRapperAge());
			preparedStatement.setInt(3, rapper.getRapperId());
			
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
