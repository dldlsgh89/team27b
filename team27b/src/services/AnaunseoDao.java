package services;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;





public class AnaunseoDao {
	
	public ArrayList<Anaunseo> SelectAnaunseoList() {
		ArrayList<Anaunseo> ana = null;
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
			
			
			
			
		}catch(SQLException sqlex){
			sqlex.getMessage();
			sqlex.printStackTrace();
			
		} catch (ClassNotFoundException cnfe) {
			// ĳġ�� �ϳ��ȿ� �� ���� ���Ѵ�. ���� ������ ���־���Ѵ�
			cnfe.printStackTrace();
		}finally {
			
		}
		return ana;  //���� Ÿ���� ������ ������ return�� �ʿ��� 
	
	}
}
