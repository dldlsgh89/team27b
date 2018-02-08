package services;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import services.Anaunseo;





public class AnaunseoDao {
	
	public ArrayList<Anaunseo> SelectAnaunseoList() {
		ArrayList<Anaunseo> ArrayAna = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
	
		try {
			//����̺� �ε�
			Class.forName("com.mysql.jdbc.Driver");
			//db����
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			//���� ���� �غ�
			pstmt = conn.prepareStatement("select * from tb_member");
			//���� ���� ����
			rs = pstmt.executeQuery();

			
//while���� ���� �غ�� ���������� �����ϰ� ���� �޾Ƽ� ���� ������ ���������� �ݺ��ϴ� �޼��带 ������ 
//select ������������ �˻��� �� �÷������� �޾� anaunseoŬ���� Ÿ���� ��̸���Ʈ ��ü�� ����� �������� ���� ana Dto�� �����Ѵ�?
			ArrayAna = new ArrayList<Anaunseo>();
			while(rs.next()) {									
			Anaunseo ana = new Anaunseo();
			   ana.setAnaunseoid(rs.getString("anaunseo_id"));
			   ana.setAnaunseoname(rs.getString("anaunseo_name"));
			   ana.setAnaunseoage(rs.getString("anaunseo_age"));	
			   
			   ArrayAna.add(ana);
			}
			
			

		}catch(SQLException sqlex){
			sqlex.getMessage();
			sqlex.printStackTrace();
			
		} catch (ClassNotFoundException cnfe) {
			// ĳġ�� �ϳ��ȿ� �� ���� ���Ѵ�. ���� ������ ���־���Ѵ�
			cnfe.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn != null) try {conn.close();} catch(SQLException ex) {}
		}
		return ArrayAna;  //���� Ÿ���� ������ ������ return�� �ʿ��� 
	
	}
}
