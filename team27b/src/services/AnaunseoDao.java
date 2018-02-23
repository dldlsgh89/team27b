//27기 B조 이인호

package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import services.Anaunseo;

public class AnaunseoDao {
	
	public void updateAnaunseoAction(int anaunseoid, String anaunseoname,int anaunseoage) {
		Connection connnection = null;
		PreparedStatement preparedstatement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connnection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedstatement = connnection.prepareStatement("update anaunseo set anaunseo_name=?,anaunseo_age=? where anaunseo_id=?");
			preparedstatement.setString(1, anaunseoname);
			preparedstatement.setInt(2, anaunseoage);
			preparedstatement.setInt(3, anaunseoid);		
			
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
	
	public Anaunseo updateAnaunseoForm(int AnaunseoId) {
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
			preparedstatement.setInt(1, AnaunseoId);
			resultset = preparedstatement.executeQuery();
		
			while(resultset.next()) {		
			   anaunseo.setAnaunseoId(resultset.getInt("anaunseo_id"));
			   anaunseo.setAnaunseoName(resultset.getString("anaunseo_name"));
			   anaunseo.setAnaunseoAge(resultset.getInt("anaunseo_age"));	
			}			
		}catch(SQLException sqlex){
			sqlex.getMessage(); //어떻게 출력된다고 했었는데 기억이 안난다
			sqlex.printStackTrace();
			
		} catch (ClassNotFoundException classex) {
			// 캐치는 하나안에 다 들어가지 못한다. 따로 나누어 써주어야한다
			classex.printStackTrace();
		}finally {
			if(resultset != null) try {resultset.close();} catch(SQLException sqlex) {}
			if(preparedstatement != null) try {preparedstatement.close();} catch(SQLException sqlex) {}
			if(connection != null) try {connection.close();} catch(SQLException sqlex) {}
		}
		return anaunseo;		
	}
	
	public void deleteAnaunseo(int AnaunseoId){
		Connection connention = null;
		PreparedStatement preparedstatement = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				connention = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
				
				preparedstatement = connention.prepareStatement("delete from anaunseo where anaunseo_id = ?");
				preparedstatement.setInt(1, AnaunseoId);
				
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
		ArrayList<Anaunseo> ArrayAna = new ArrayList<Anaunseo>();
		Connection connention = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			//드라이브 로딩
			Class.forName("com.mysql.jdbc.Driver");
			//db연결
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connention = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			//쿼리 실행 준비
			preparedstatement = connention.prepareStatement("select anaunseo_id,anaunseo_name,anaunseo_age from anaunseo");
										//// anaunseo_id as anaunseoid = 컬럼명 anaunseo_id을 anaunseoid 바꾼다 as나 ""는 생략이 가능하다
			
			//쿼리 실행 시작
			resultset = preparedstatement.executeQuery();
		
//while문을 통해 준비된 쿼리문장을 실행하고 값을 받아서 값이 나오지 않을때까지 반복하는 메서드를 만든후 
//select 쿼리문장으로 검색된 각 컬럼값들을 받아 anaunseo클래스 타입의 어레이리스트 객체를 만들어 참조값을 담은 ana Dto에 셋팅한다?
			while(resultset.next()) {									
			Anaunseo anaunseo = new Anaunseo();
			   anaunseo.setAnaunseoId(resultset.getInt("anaunseo_id"));
			   anaunseo.setAnaunseoName(resultset.getString("anaunseo_name"));
			   anaunseo.setAnaunseoAge(resultset.getInt("anaunseo_age"));	
			   ArrayAna.add(anaunseo);
			}			
		}catch(SQLException sqlex){
			sqlex.getMessage(); //어떻게 출력된다고 했었는데 기억이 안난다
			sqlex.printStackTrace();
			
		} catch (ClassNotFoundException classex) {
			// 캐치는 하나안에 다 들어가지 못한다. 따로 나누어 써주어야한다
			classex.printStackTrace();
		}finally {
			if(resultset != null) try {resultset.close();} catch(SQLException sqlex) {}
			if(preparedstatement != null) try {preparedstatement.close();} catch(SQLException sqlex) {}
			if(connention != null) try {connention.close();} catch(SQLException sqlex) {}
		}
		return ArrayAna;  //리턴 타입이 있으니 무조껀 return이 필요함 
	
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
