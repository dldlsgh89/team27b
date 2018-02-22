//27�� B�� ����ȣ

package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import services.Anaunseo;

public class AnaunseoDao {
	
	public void anaunseoUpdateAction(int anaunseoid, String anaunseoname,int anaunseoage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("update anaunseo set anaunseo_name=?,anaunseo_age=? where anaunseo_id=?");
			pstmt.setString(1, anaunseoname);
			pstmt.setInt(2, anaunseoage);
			pstmt.setInt(3, anaunseoid);		
			
			pstmt.executeUpdate();
			
			
		}catch(ClassNotFoundException cnfex){
			cnfex.printStackTrace();
		}catch(SQLException sqle) {	
			sqle.printStackTrace();
		}finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException sqle) {}
			if(conn != null) try {conn.close();} catch(SQLException sqle) {}
		}
		
		
		
		
	}
	
	public Anaunseo anaunseoUpdateForm(int AnaunseoId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Anaunseo ana = new Anaunseo();
		try {		
			Class.forName("com.mysql.jdbc.Driver");		
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);	
			pstmt = conn.prepareStatement("select * from anaunseo where anaunseo_id = ?");		
			pstmt.setInt(1, AnaunseoId);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {		
			   ana.setAnaunseoId(rs.getInt("anaunseo_id"));
			   ana.setAnaunseoName(rs.getString("anaunseo_name"));
			   ana.setAnaunseoAge(rs.getInt("anaunseo_age"));	
			}			
		}catch(SQLException sqlex){
			sqlex.getMessage(); //��� ��µȴٰ� �߾��µ� ����� �ȳ���
			sqlex.printStackTrace();
			
		} catch (ClassNotFoundException cnfe) {
			// ĳġ�� �ϳ��ȿ� �� ���� ���Ѵ�. ���� ������ ���־���Ѵ�
			cnfe.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException sqlex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException sqlex) {}
			if(conn != null) try {conn.close();} catch(SQLException sqlex) {}
		}
		return ana;		
	}
	
	public void deleteAnaunseoList(int AnaunseoId){
		Connection conn = null;
		PreparedStatement pstmt = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
				
				pstmt = conn.prepareStatement("delete from anaunseo where anaunseo_id = ?");
				pstmt.setInt(1, AnaunseoId);
				
				pstmt.executeUpdate();
			}catch(SQLException ex){
				ex.printStackTrace();
			}catch(ClassNotFoundException cnfe){
				cnfe.printStackTrace();
			}finally{
				if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
				if(conn != null) try {conn.close();} catch(SQLException ex) {}
			}
	}
	
	
	public ArrayList<Anaunseo> selectAnaunseoList() {
		ArrayList<Anaunseo> ArrayAna = new ArrayList<Anaunseo>();
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
			pstmt = conn.prepareStatement("select anaunseo_id,anaunseo_name,anaunseo_age from anaunseo");
										//// anaunseo_id as anaunseoid = �÷��� anaunseo_id�� anaunseoid �ٲ۴� as�� ""�� ������ �����ϴ�
			
			//���� ���� ����
			rs = pstmt.executeQuery();
		
//while���� ���� �غ�� ���������� �����ϰ� ���� �޾Ƽ� ���� ������ ���������� �ݺ��ϴ� �޼��带 ������ 
//select ������������ �˻��� �� �÷������� �޾� anaunseoŬ���� Ÿ���� ��̸���Ʈ ��ü�� ����� �������� ���� ana Dto�� �����Ѵ�?
			while(rs.next()) {									
			Anaunseo ana = new Anaunseo();
			   ana.setAnaunseoId(rs.getInt("anaunseo_id"));
			   ana.setAnaunseoName(rs.getString("anaunseo_name"));
			   ana.setAnaunseoAge(rs.getInt("anaunseo_age"));	
			   ArrayAna.add(ana);
			}			
		}catch(SQLException sqlex){
			sqlex.getMessage(); //��� ��µȴٰ� �߾��µ� ����� �ȳ���
			sqlex.printStackTrace();
			
		} catch (ClassNotFoundException cnfe) {
			// ĳġ�� �ϳ��ȿ� �� ���� ���Ѵ�. ���� ������ ���־���Ѵ�
			cnfe.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException sqlex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException sqlex) {}
			if(conn != null) try {conn.close();} catch(SQLException sqlex) {}
		}
		return ArrayAna;  //���� Ÿ���� ������ ������ return�� �ʿ��� 
	
	}
	
	public void insertAnaunseo(Anaunseo ana) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("insert into anaunseo values (0, ?, ?)");
			
			
			pstmt.setString(1, ana.getAnaunseoName());
			pstmt.setInt(2, ana.getAnaunseoAge());
			
			pstmt.executeUpdate();
			
			
		}catch(ClassNotFoundException cnfex){
			cnfex.printStackTrace();
		}catch(SQLException sqle) {	
			sqle.printStackTrace();
		}finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException sqle) {}
			if(conn != null) try {conn.close();} catch(SQLException sqle) {}
		}
		
		
	}
	

}
