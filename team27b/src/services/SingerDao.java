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
			pstmt = conn.prepareStatement("SELECT singer_id,singer_name,singer_age FROM singer");
			// ���Ϲ��� �ּҰ��� �޾� statement��ü�� �� �� ���������� �ϰ� ResultSet��ü�� �����Ͽ� ���� ���� ����� �����Ϳ����� ��� ������ �ּҰ��� �����Ͽ� rs ���������� ��´�
			rs = pstmt.executeQuery();
			// ���Ϲ��� �ּҰ��� �޾� ResultSet��ü�� next�޼��带 ȣ���Ͽ� �����Ϳ����� ���� ���� ���������� ������ �о� ���� �����ϸ� true���� �����ϰ�
			//�������� ������ false���� �����Ѵ� while �ݺ����� ������ ���ϰ�� ��ϳ� ��ɹ��� �ݺ������ϰ� �����϶� �ݺ��� ���߰� ���� ���� �ܰ�� �ѱ��
			while(rs.next()) {
				// 
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
