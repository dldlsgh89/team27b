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
			String sql = "SELECT  actress_id as actressId,actress_name as actressName,actress_age as actressrAge from Actress FROM actress";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass); 
			preparedstatement = connection.prepareStatement(sql);
			resultset = preparedstatement.executeQuery();
			
			arrayActress = new ArrayList<Actress>();
			
			while(resultset.next()) {
				Actress actress = new Actress();
				actress.setActressId(resultset.getInt("actressId"));
				actress.setActressName(resultset.getString("actressName"));
				actress.setActressAge(resultset.getInt("actressrAge"));
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
}
