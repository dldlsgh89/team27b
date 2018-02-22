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
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
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
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			// ���Ϲ��� �ּҰ��� �޾� Connection��ü�� �� �� �������� �غ�޼��带 �����ϰ� statement��ü�� ���� ���� �� �� �ּҰ��� ���Ͻ��� pstmt ���������� ��´�
			pstmt = conn.prepareStatement("SELECT singer_id,singer_name,singer_age FROM singer ORDER BY singer_id ASC");
			// ���Ϲ��� �ּҰ��� �޾� statement��ü�� �� �� ���������� �ϰ� ResultSet��ü�� �����Ͽ� ���� ���� ����� �����Ϳ����� ��� ������ �ּҰ��� �����Ͽ� rs ���������� ��´�
			rs = pstmt.executeQuery();
			// ���Ϲ��� �ּҰ��� �޾� ResultSet��ü�� next�޼��带 ȣ���Ͽ� �����Ϳ����� ���� ���� ���������� ������ �о� ���� �����ϸ� true���� �����ϰ�
			//�������� ������ false���� �����Ѵ� while �ݺ����� ������ ���ϰ�� ��ϳ� ��ɹ��� �ݺ������ϰ� �����϶� �ݺ��� ���߰� ���� ���� �ܰ�� �ѱ��
			while(rs.next()) {
				// Singer��ü�� �����Ͽ� DB���� �����µ����͸� ��ü���� �����ϰ� list�� �����Ѵ�
				Singer singer = new Singer();
				singer.setSingerId(rs.getInt("singer_id"));
				singer.setSingerName(rs.getString("singer_name"));
				singer.setSingerAge(rs.getInt("singer_age"));
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
			if(rs == null) try {rs.close();}catch(SQLException ex){}
			if(pstmt == null) try {rs.close();}catch(SQLException ex){}
			if(conn == null) try {rs.close();}catch(SQLException ex){}
		}
		// Singer �迭 �ּҰ��� ���Ͻ�Ų��
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
