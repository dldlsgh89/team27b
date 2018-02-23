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
	
	public void updateAnaunseoAction(int anaunseoId, String anaunseoName,int anaunseoAge) {
		Connection connnection = null;
		PreparedStatement preparedstatement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connnection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedstatement = connnection.prepareStatement("update anaunseo set anaunseo_name=?,anaunseo_age=? where anaunseo_id=?");
			preparedstatement.setString(1, anaunseoName);
			preparedstatement.setInt(2, anaunseoAge);
			preparedstatement.setInt(3, anaunseoId);		
			
			preparedstatement.executeUpdate();
			
			
		}catch(ClassNotFoundException classex){
			classex.printStackTrace();
		}catch(SQLException sqlex) {	
			sqlex.printStackTrace();
		}finally {
			if(preparedstatement != null) try {preparedstatement.close();} catch(SQLException sqlex) {}
			if(connnection != null) try {connnection.close();} catch(SQLException sqlex) {}
		}
		
		
		
		
	}
	
	public Anaunseo updateAnaunseoForm(int anaunseoId) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		Anaunseo anaunseo = new Anaunseo();
		try {		
			Class.forName("com.mysql.jdbc.Driver");		
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);	
			preparedstatement = connection.prepareStatement("select * from anaunseo where anaunseo_id = ?");		
			preparedstatement.setInt(1, anaunseoId);
			resultset = preparedstatement.executeQuery();
		
			while(resultset.next()) {		
			   anaunseo.setAnaunseoId(resultset.getInt("anaunseo_id"));
			   anaunseo.setAnaunseoName(resultset.getString("anaunseo_name"));
			   anaunseo.setAnaunseoAge(resultset.getInt("anaunseo_age"));	
			}			
		}catch(SQLException sqlex){
			sqlex.getMessage(); //��� ��µȴٰ� �߾��µ� ����� �ȳ���
			sqlex.printStackTrace();
			
		} catch (ClassNotFoundException classex) {
			// ĳġ�� �ϳ��ȿ� �� ���� ���Ѵ�. ���� ������ ���־���Ѵ�
			classex.printStackTrace();
		}finally {
			if(resultset != null) try {resultset.close();} catch(SQLException sqlex) {}
			if(preparedstatement != null) try {preparedstatement.close();} catch(SQLException sqlex) {}
			if(connection != null) try {connection.close();} catch(SQLException sqlex) {}
		}
		return anaunseo;		
	}
	
	public void deleteAnaunseo(int anaunseoId){
		Connection connention = null;
		PreparedStatement preparedstatement = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				connention = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
				
				preparedstatement = connention.prepareStatement("delete from anaunseo where anaunseo_id = ?");
				preparedstatement.setInt(1, anaunseoId);
				
				preparedstatement.executeUpdate();
			}catch(SQLException sqlex){
				sqlex.printStackTrace();
			}catch(ClassNotFoundException classex){
				classex.printStackTrace();
			}finally{
				if(preparedstatement != null) try {preparedstatement.close();} catch(SQLException sqlex) {}
				if(connention != null) try {connention.close();} catch(SQLException sqlex) {}
			}
	}
	
	
	public ArrayList<Anaunseo> selectAnaunseoList() {
		ArrayList<Anaunseo> arrayAnaunseo = new ArrayList<Anaunseo>();
		Connection connention = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			//����̺� �ε�
			Class.forName("com.mysql.jdbc.Driver");
			//db����
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connention = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			//���� ���� �غ�
			preparedstatement = connention.prepareStatement("select anaunseo_id,anaunseo_name,anaunseo_age from anaunseo");
										//// anaunseo_id as anaunseoid = �÷��� anaunseo_id�� anaunseoid �ٲ۴� as�� ""�� ������ �����ϴ�
			
			//���� ���� ����
			resultset = preparedstatement.executeQuery();
		
//while���� ���� �غ�� ���������� �����ϰ� ���� �޾Ƽ� ���� ������ ���������� �ݺ��ϴ� �޼��带 ������ 
//select ������������ �˻��� �� �÷������� �޾� anaunseoŬ���� Ÿ���� ��̸���Ʈ ��ü�� ����� �������� ���� ana Dto�� �����Ѵ�?
			while(resultset.next()) {									
			Anaunseo anaunseo = new Anaunseo();
			   anaunseo.setAnaunseoId(resultset.getInt("anaunseo_id"));
			   anaunseo.setAnaunseoName(resultset.getString("anaunseo_name"));
			   anaunseo.setAnaunseoAge(resultset.getInt("anaunseo_age"));	
			   arrayAnaunseo.add(anaunseo);
			}			
		}catch(SQLException sqlex){
			sqlex.getMessage(); //��� ��µȴٰ� �߾��µ� ����� �ȳ���
			sqlex.printStackTrace();
			
		} catch (ClassNotFoundException classex) {
			// ĳġ�� �ϳ��ȿ� �� ���� ���Ѵ�. ���� ������ ���־���Ѵ�
			classex.printStackTrace();
		}finally {
			if(resultset != null) try {resultset.close();} catch(SQLException sqlex) {}
			if(preparedstatement != null) try {preparedstatement.close();} catch(SQLException sqlex) {}
			if(connention != null) try {connention.close();} catch(SQLException sqlex) {}
		}
		return arrayAnaunseo;  //���� Ÿ���� ������ ������ return�� �ʿ��� 
	
	}
	
	public void insertAnaunseo(String anaunseName,int anaunseoAge) {
		Connection connention = null;
		PreparedStatement preparedstatement = null;
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connention = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedstatement = connention.prepareStatement("insert into anaunseo values (0, ?, ?)");
			preparedstatement.setString(1, anaunseName);
			preparedstatement.setInt(2, anaunseoAge);
			
						
			preparedstatement.executeUpdate();
			
			
		}catch(ClassNotFoundException classex){
			classex.printStackTrace();
		}catch(SQLException sqlex) {	
			sqlex.printStackTrace();
		}finally {
			if(preparedstatement != null) try {preparedstatement.close();} catch(SQLException sqlex) {}
			if(connention != null) try {connention.close();} catch(SQLException sqlex) {}
		}
		
		
	}
	

}
