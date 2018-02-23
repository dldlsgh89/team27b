//������

package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RapperDao {
	// selectRapperList�޼��� ����
	public ArrayList<Rapper> selectRapperList() {
		// jdbc���� ���������� �����Ѵ�
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//Rapper �迭�� �����
		ArrayList<Rapper> arrayRapper = new ArrayList<Rapper>();
		try {
			// ����̹� �ε�
			Class.forName("com.mysql.jdbc.Driver");
			// DB������� ������ ip�ּ�,��Ʈ��ȣ,db��,dbid,dbpw������ ��´�
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
				arrayRapper.add(rapper);
			}
		}catch(SQLException sqlex) {
			sqlex.getStackTrace();
			System.out.println(sqlex.getMessage());
		} catch (ClassNotFoundException classex) {
			classex.printStackTrace();
			System.out.println(classex.getMessage());
		}finally {
			if(resultSet == null) try {resultSet.close();}catch(SQLException ex){}
			if(preparedStatement == null) try {resultSet.close();}catch(SQLException ex){}
			if(connection == null) try {resultSet.close();}catch(SQLException ex){}
		}
		
		return arrayRapper;
	}
	
	public void insertRapper(String rapperName,int rapperAge) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedStatement = connection.prepareStatement("insert into rapper values (0, ?, ?)");
			
			preparedStatement.setString(1, rapperName);
			preparedStatement.setInt(2, rapperAge);
			
			preparedStatement.executeUpdate();
			
		}catch(ClassNotFoundException classex) {
			classex.printStackTrace();
		} catch(SQLException sqlex) {
			sqlex.printStackTrace();
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
			
		}catch(ClassNotFoundException classex) {
			classex.printStackTrace();
		} catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}finally {
			if (preparedStatement != null) try { preparedStatement.close(); } catch(SQLException ex) {} 
			if (connection != null) try { connection.close(); } catch(SQLException ex) {} 
		}
	}
	
	public Rapper updateRapperForm(int rapperId) {
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
			
		}catch(ClassNotFoundException classex){
			classex.getMessage();
		}catch(SQLException sqlex) {	
			sqlex.printStackTrace();
		}finally {
			if(resultset != null) try{resultset.close();} catch(SQLException sqle) {}
			if(preparedStatement != null) try{preparedStatement.close();} catch(SQLException sqle) {}
			if(connection != null) try{connection.close();}  catch(SQLException sqle) {}
		}
		
		return rapper;
	}
	
	public void updateRapperAction(int rapperId,String rapperName,int rapperAge) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedStatement = connection.prepareStatement("UPDATE rapper SET rapper_name=?, rapper_age=? WHERE rapper_id=?");
			preparedStatement.setString(1, rapperName);
			preparedStatement.setInt(2, rapperAge);
			preparedStatement.setInt(3, rapperId);
			
			preparedStatement.executeUpdate();
			
		}catch(ClassNotFoundException classex){
			classex.getMessage();
		}catch(SQLException sqlex) {	
			sqlex.printStackTrace();
		}finally {
			if(preparedStatement != null) try{preparedStatement.close();} catch(SQLException sqle) {}
			if(connection != null) try{connection.close();}  catch(SQLException sqle) {}
		}
			
	}
}
