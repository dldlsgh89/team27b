//27±â BÁ¶ ¹è°ÇÇý
package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActressDao {
	public ArrayList<Actress> selectActressList(){
		ArrayList<Actress> arrayActress = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&charaterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass); 
			preparedstatement = connection.prepareStatement("SELECT actress_id,actress_name,actress_age FROM actress");
			resultset = preparedstatement.executeQuery();
			
			arrayActress = new ArrayList<Actress>();
			
			while(resultset.next()) {
				Actress actress = new Actress();
				actress.setActressId(Integer.parseInt( resultset.getString("actress_id")));
				actress.setActressName(resultset.getString("actress_name"));
				actress.setActressAge(resultset.getInt("actress_age"));
				arrayActress.add(actress);
				}
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch(SQLException e) {
				e.printStackTrace();
			}finally { 
				if (resultset != null) try { resultset.close(); } catch(SQLException ex) {} 
				if (preparedstatement != null) try { preparedstatement.close(); } catch(SQLException ex) {} 
				if (connection != null) try { connection.close(); } catch(SQLException ex) {} 
			}
			return arrayActress;
	}
	public void insertActress(Actress actress) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&charaterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement("insert into actress values (0, ?, ?)");
			
			preparedstatement.setString(1, actress.getActressName());
			preparedstatement.setInt(2, actress.getActressAge());
			
			preparedstatement.executeUpdate();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally { 
			if (resultset != null) try { resultset.close(); } catch(SQLException ex) {} 
			if (preparedstatement != null) try { preparedstatement.close(); } catch(SQLException ex) {} 
			if (connection != null) try { connection.close(); } catch(SQLException ex) {} 
		}
	}
}
