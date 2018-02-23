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
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		//Rapper 배열을 만든다
		ArrayList<Rapper> arrayRapper = new ArrayList<Rapper>();
		try {
			// 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			// DB연결관련 변수에 ip주소,포트번호,db명,dbid,dbpw값들을 담는다
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedstatement = connection.prepareStatement("SELECT rapper_id,rapper_name,rapper_age FROM rapper");
			
			resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				Rapper rapper = new Rapper();
				rapper.setRapperId(resultset.getInt("rapper_id"));
				rapper.setRapperName(resultset.getString("rapper_name"));
				rapper.setRapperAge(resultset.getInt("rapper_age"));
				arrayRapper.add(rapper);
			}
		}catch(SQLException sqlex) {
			sqlex.getStackTrace();
			System.out.println(sqlex.getMessage());
		} catch (ClassNotFoundException classex) {
			classex.printStackTrace();
			System.out.println(classex.getMessage());
		}finally {
			if(resultset == null) try {resultset.close();}catch(SQLException sqlex){}
			if(preparedstatement == null) try {resultset.close();}catch(SQLException sqlex){}
			if(connection == null) try {resultset.close();}catch(SQLException sqlex){}
		}
		
		return arrayRapper;
	}
	
	public void insertRapper(String rapperName,int rapperAge) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement("insert into rapper values (0, ?, ?)");
			
			preparedstatement.setString(1, rapperName);
			preparedstatement.setInt(2, rapperAge);
			
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
	
	public void deleteRapper(int rapperId) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement("DELETE FROM rapper WHERE rapper_id=?");
			
			preparedstatement.setInt(1, rapperId);			
			
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
	
	public Rapper updateRapperForm(int rapperId) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		Rapper rapper = new Rapper();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedstatement = connection.prepareStatement("SELECT rapper_id,rapper_name,rapper_age FROM rapper WHERE rapper_id=?");
			preparedstatement.setInt(1, rapperId);
			
			resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				rapper.setRapperId(resultset.getInt("rapper_id"));
				rapper.setRapperName(resultset.getString("rapper_name"));
				rapper.setRapperAge(resultset.getInt("rapper_age"));
			}
			
		}catch(ClassNotFoundException classex){
			classex.getMessage();
		}catch(SQLException sqlex) {	
			sqlex.printStackTrace();
		}finally {
			if(resultset != null) try{resultset.close();} catch(SQLException sqlex) {}
			if(preparedstatement != null) try{preparedstatement.close();} catch(SQLException sqlex) {}
			if(connection != null) try{connection.close();}  catch(SQLException sqlex) {}
		}
		
		return rapper;
	}
	
	public void updateRapperAction(int rapperId,String rapperName,int rapperAge) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedstatement = connection.prepareStatement("UPDATE rapper SET rapper_name=?, rapper_age=? WHERE rapper_id=?");
			preparedstatement.setString(1, rapperName);
			preparedstatement.setInt(2, rapperAge);
			preparedstatement.setInt(3, rapperId);
			
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
