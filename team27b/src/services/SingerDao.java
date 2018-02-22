//������

package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class SingerDao {
	// selectSingerList�޼��� ����
	public ArrayList<Singer> selectSingerList() {
		// jdbc���� ���������� �����Ѵ�
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//Singer �迭�� �����
		ArrayList<Singer> list = new ArrayList<Singer>();
		try {
			//����̹� �ε�
			Class.forName("com.mysql.jdbc.Driver");
			// DB������� ������ ip�ּ�,��Ʈ��ȣ,db��,dbid,dbpw������ ��´�
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			// DB������� ������ ��䰪���� getConnection�޼��带 ���� DB������ �� �� Connection��ü�� �����Ͽ� �ּҰ��� ���Ͻ��� conn ���������� ��´�
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			// ���Ϲ��� �ּҰ��� �޾� Connection��ü�� �� �� �������� �غ�޼��带 �����ϰ� statement��ü�� ���� ���� �� �� �ּҰ��� ���Ͻ��� pstmt ���������� ��´�
			preparedStatement = connection.prepareStatement("SELECT singer_id,singer_name,singer_age FROM singer ORDER BY singer_id ASC");
			// ���Ϲ��� �ּҰ��� �޾� statement��ü�� �� �� ���������� �ϰ� ResultSet��ü�� �����Ͽ� ���� ���� ����� �����Ϳ����� ��� ������ �ּҰ��� �����Ͽ� rs ���������� ��´�
			resultSet = preparedStatement.executeQuery();
			// ���Ϲ��� �ּҰ��� �޾� ResultSet��ü�� next�޼��带 ȣ���Ͽ� �����Ϳ����� ���� ���� ���������� ������ �о� ���� �����ϸ� true���� �����ϰ�
			//�������� ������ false���� �����Ѵ� while �ݺ����� ������ ���ϰ�� ��ϳ� ��ɹ��� �ݺ������ϰ� �����϶� �ݺ��� ���߰� ���� ���� �ܰ�� �ѱ��
			while(resultSet.next()) {
				// Singer��ü�� �����Ͽ� DB���� �����µ����͸� ��ü���� �����ϰ� list�� �����Ѵ�
				Singer singer = new Singer();
				singer.setSingerId(resultSet.getInt("singer_id"));
				singer.setSingerName(resultSet.getString("singer_name"));
				singer.setSingerAge(resultSet.getInt("singer_age"));
				list.add(singer);
			}
		// jdbc���� ���ܹ߻��� catch�κ����� �Ѱ� ó���Ѵ�
		}catch(SQLException ex) {
			// ���ܹ߻��� java������ �˷��ش�
			ex.getStackTrace();
			// ���ܹ߻��� ������ �˷��ش�
			System.out.println(ex.getMessage());
		// Class.forName���� ���ܹ߻��� catch�κ����� �Ѱ� ó���Ѵ�
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			// ����� ��ü���� �������ش�
			if(resultSet == null) try {resultSet.close();}catch(SQLException ex){}
			if(preparedStatement == null) try {resultSet.close();}catch(SQLException ex){}
			if(connection == null) try {resultSet.close();}catch(SQLException ex){}
		}
		// Singer �迭 �ּҰ��� ���Ͻ�Ų��
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
