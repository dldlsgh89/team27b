//27기 B조 이인호

package services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import org.apache.catalina.connector.Request;

public class ComedianDao {
	
	public void updateComedianAction(int comedianId, String comedianName,int comedianAge) {
		Connection connnection = null;
		PreparedStatement preparedstatememt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connnection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedstatememt = connnection.prepareStatement("update comedian set comedian_name=?,comedian_age=? where comedian_id=?");
			preparedstatememt.setString(1, comedianName);
			preparedstatememt.setInt(2, comedianAge);
			preparedstatememt.setInt(3, comedianId);		
			
			preparedstatememt.executeUpdate();
			
			
		}catch(ClassNotFoundException classex){
			classex.printStackTrace();
		}catch(SQLException sqlex) {	
			sqlex.printStackTrace();
		}finally {
			if(preparedstatememt != null) try {preparedstatememt.close();} catch(SQLException sqlex) {}
			if(preparedstatememt != null) try {preparedstatememt.close();} catch(SQLException sqlex) {}
		}
	}
	
	public Comedian updateComedianForm(int comedianId) {
		Connection connnection = null;
		PreparedStatement preparedstatememt = null;
		ResultSet resultset = null;
		Comedian comedian = new Comedian();
		try {		
			Class.forName("com.mysql.jdbc.Driver");		
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connnection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);	
			preparedstatememt = connnection.prepareStatement("select * from comedian where comedian_id = ?");		
			preparedstatememt.setInt(1, comedianId);
			resultset = preparedstatememt.executeQuery();
		
			while(resultset.next()) {		
			   comedian.setComedianId(resultset.getInt("comedian_id"));;
			   comedian.setComedianName(resultset.getString("comedian_name"));
			   comedian.setComedianAge(resultset.getInt("comedian_age"));;	
			}			
		}catch(SQLException sqlex){
			sqlex.getMessage(); //어떻게 출력된다고 했었는데 기억이 안난다
			sqlex.printStackTrace();
			
		} catch (ClassNotFoundException classex) {
			// 캐치는 하나안에 다 들어가지 못한다. 따로 나누어 써주어야한다
			classex.printStackTrace();
		}finally {
			if(resultset != null) try {resultset.close();} catch(SQLException sqlex) {}
			if(preparedstatememt != null) try {preparedstatememt.close();} catch(SQLException sqlex) {}
			if(connnection != null) try {connnection.close();} catch(SQLException sqlex) {}
		}
		return comedian;		
	}
	
	public void deleteComedian(int comedianId){
		Connection connnection = null;
		PreparedStatement preparedstatememt = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				connnection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
				
				preparedstatememt = connnection.prepareStatement("delete from comedian where comedian_id = ?");
				preparedstatememt.setInt(1, comedianId);
				
				preparedstatememt.executeUpdate();
			}catch(SQLException sqlex){
				sqlex.printStackTrace();
			}catch(ClassNotFoundException classex){
				classex.printStackTrace();
			}finally{
				if(preparedstatememt != null) try {preparedstatememt.close();} catch(SQLException sqlex) {}
				if(connnection != null) try {connnection.close();} catch(SQLException sqlex) {}
			}
	}

	public ArrayList<Comedian> selectComedianList(){
		ArrayList<Comedian> arrayComedian = new ArrayList<Comedian>();
		Connection connnection = null;
		PreparedStatement preparedstatememt = null;
		ResultSet resultset = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connnection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedstatememt = connnection.prepareStatement("select comedian_id,comedian_name,comedian_age from comedian");
			//select+ORDER BY+ASC내림차순?? 
			resultset = preparedstatememt.executeQuery();
			
			while(resultset.next()) {
				Comedian comedian = new Comedian();
				comedian.setComedianId(Integer.parseInt(resultset.getString("comedian_id")));
				comedian.setComedianName(resultset.getString("comedian_name"));
				comedian.setComedianAge(resultset.getInt("comedian_age"));
				
				arrayComedian.add(comedian);
			}
			
		}catch(ClassNotFoundException classex){
			classex.getMessage();
		}catch(SQLException sqlex) {	
			sqlex.printStackTrace();
		}finally {
			if(resultset != null) try{resultset.close();} catch(SQLException sqlex) {}
			if(preparedstatememt != null) try{preparedstatememt.close();} catch(SQLException sqlex) {}
			if(connnection != null) try{connnection.close();}  catch(SQLException sqlex) {}
		}
		
		
		return arrayComedian;
		
	}
	
	public void insertComedian(String comemianName,int comedianAge) {
		Connection connnection = null;
		PreparedStatement preparedstatememt = null;
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connnection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedstatememt = connnection.prepareStatement("insert into comedian values (0, ?, ?)");
			preparedstatememt.setString(1, comemianName);
			preparedstatememt.setInt(2, comedianAge);
			
		
			
			preparedstatememt.executeUpdate();
			
			
		}catch(ClassNotFoundException classex){
			classex.printStackTrace();
		}catch(SQLException sqlex) {	
			sqlex.printStackTrace();
		}finally {
			if(preparedstatememt != null) try {preparedstatememt.close();} catch(SQLException sqlex) {}
			if(connnection != null) try {connnection.close();} catch(SQLException sqlex) {}
		}
		
		
	}
	
	
}
