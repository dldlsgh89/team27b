//27±â BÁ¶ ¹è°ÇÇý  
package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class ActorDao {
	public ArrayList<Actor> selectActorList(){
		ArrayList<Actor> arrayActor = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		Connection connection = null;
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&charaterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT  actor_id as actorId,actor_name as actorName,actor_age as actorAge from Actress FROM actor";
					
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass); 
			preparedstatement = connection.prepareStatement(sql);
			resultset = preparedstatement.executeQuery();
			
			arrayActor = new ArrayList<Actor>();
			
			while(resultset.next()) {
				Actor actor = new Actor();
				actor.setActorId(resultset.getInt(" actorId"));
				actor.setActorName(resultset.getString("actorName"));
				actor.setActorAge(resultset.getInt("actorAge"));
				arrayActor.add(actor);			
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
		return arrayActor;
	}
}

