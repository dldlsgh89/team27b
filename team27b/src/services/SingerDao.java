//������

package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class SingerDao {
	/*
	 * selectSingerList�޼��� ����
	 * DB�� ����ִ� ���������� ��ü����Ʈ�� �̾��ִ� �޼����̴�
	 */
	public ArrayList<Singer> selectSingerList() {
		/*
		 * jdbc���� ���������� �����Ѵ�
		 * DB�� ����ϱ����� �ʿ��� �������̴�
		 */
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		/*
		 * Singer �迭�� �����
		 * �������� ���������͸� ���� ������ ������ش�
		 */
		ArrayList<Singer> arraySinger = new ArrayList<Singer>();
		try {
			/*����̹� �ε�*/
			Class.forName("com.mysql.jdbc.Driver");
			/*
			 * DB������� ������ ip�ּ�,��Ʈ��ȣ,db��,dbid,dbpw������ ��´�
			 * �ּҿ� ���̵� �н����尡 ��ġ�ؾ߸� DB�� ����Ҽ��� �ִ�
			 */
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			// DB������� ������ ��䰪���� getConnection�޼��带 ���� DB������ �� �� Connection��ü�� �����Ͽ� �ּҰ��� ���Ͻ��� conn ���������� ��´�
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			// ���Ϲ��� �ּҰ��� �޾� Connection��ü�� �� �� �������� �غ�޼��带 �����ϰ� statement��ü�� ���� ���� �� �� �ּҰ��� ���Ͻ��� pstmt ���������� ��´�
			preparedstatement = connection.prepareStatement("SELECT singer_id,singer_name,singer_age FROM singer ORDER BY singer_id ASC");
			// ���Ϲ��� �ּҰ��� �޾� statement��ü�� �� �� ���������� �ϰ� ResultSet��ü�� �����Ͽ� ���� ���� ����� �����Ϳ����� ��� ������ �ּҰ��� �����Ͽ� rs ���������� ��´�
			resultset = preparedstatement.executeQuery();
			// ���Ϲ��� �ּҰ��� �޾� ResultSet��ü�� next�޼��带 ȣ���Ͽ� �����Ϳ����� ���� ���� ���������� ������ �о� ���� �����ϸ� true���� �����ϰ�
			//�������� ������ false���� �����Ѵ� while �ݺ����� ������ ���ϰ�� ��ϳ� ��ɹ��� �ݺ������ϰ� �����϶� �ݺ��� ���߰� ���� ���� �ܰ�� �ѱ��
			while(resultset.next()) {
				// Singer��ü�� �����Ͽ� DB���� �����µ����͸� ��ü���� �����ϰ� list�� �����Ѵ�
				Singer singer = new Singer();
				singer.setSingerId(resultset.getInt("singer_id"));
				singer.setSingerName(resultset.getString("singer_name"));
				singer.setSingerAge(resultset.getInt("singer_age"));
				arraySinger.add(singer);
			}
		// jdbc���� ���ܹ߻��� catch�κ����� �Ѱ� ó���Ѵ�
		}catch(SQLException sqlex) {
			// ���ܹ߻��� java������ �˷��ش�
			sqlex.getStackTrace();
			// ���ܹ߻��� ������ �˷��ش�
			System.out.println(sqlex.getMessage());
		// Class.forName���� ���ܹ߻��� catch�κ����� �Ѱ� ó���Ѵ�
		} catch (ClassNotFoundException classex) {
			classex.printStackTrace();
			System.out.println(classex.getMessage());
		}finally {
			// ����� ��ü���� �������ش�
			if(resultset == null) try {resultset.close();}catch(SQLException sqlex){}
			if(preparedstatement == null) try {resultset.close();}catch(SQLException sqlex){}
			if(connection == null) try {resultset.close();}catch(SQLException sqlex){}
		}
		// Singer �迭 �ּҰ��� ���Ͻ�Ų��
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
