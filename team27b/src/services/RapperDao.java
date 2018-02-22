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
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//Rapper �迭�� �����
		ArrayList<Rapper> list = new ArrayList<Rapper>();
		try {
			// ����̹� �ε�
			Class.forName("com.mysql.jdbc.Driver");
			// DB������� ������ ip�ּ�,��Ʈ��ȣ,db��,dbid,dbpw������ ��´�
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("SELECT rapper_id,rapper_name,rapper_age FROM rapper");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Rapper rapper = new Rapper();
				rapper.setRapperId(rs.getInt("rapper_id"));
				rapper.setRapperName(rs.getString("rapper_name"));
				rapper.setRapperAge(rs.getInt("rapper_age"));
				list.add(rapper);
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
	
	public void insertRapper(Rapper rapper) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&charaterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement("insert into rapper values (0, ?, ?)");
			
			preparedstatement.setString(1, rapper.getRapperName());
			preparedstatement.setInt(2, rapper.getRapperAge());
			
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
