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
		ArrayList<Actor> arrayActor =  new ArrayList<Actor>();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		Connection connection = null;
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
					
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass); 
			preparedstatement = connection.prepareStatement("SELECT actor_id,actor_name,actor_age FROM actor");
			resultset = preparedstatement.executeQuery();
			
			
			
			while(resultset.next()) {
				Actor actor = new Actor();
				actor.setActorId(Integer.parseInt(resultset.getString("actor_id")));
				actor.setActorName(resultset.getString("actor_name"));
				actor.setActorAge(resultset.getInt("actor_age"));
				arrayActor.add(actor);			
			}
		}catch(ClassNotFoundException classex) {
			classex.getMessage();
			classex.printStackTrace();
		} catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}finally { 
			if (resultset != null) try { resultset.close(); } catch(SQLException sqlex) {} 
			if (preparedstatement != null) try { preparedstatement.close(); } catch(SQLException sqlex) {} 
			if (connection != null) try { connection.close(); } catch(SQLException sqlex) {} 
		}
		return arrayActor;
	}
	
	public void insertActor(String actorName, int actorAge) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement("INSERT INTO actor VALUES (0, ?, ?)");
			
			preparedstatement.setString(1, actorName);
			preparedstatement.setInt(2, actorAge);
			
			preparedstatement.executeUpdate();
			
		}catch(ClassNotFoundException classex) {
			classex.printStackTrace();
		} catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}finally { 
			if (resultset != null) try { resultset.close(); } catch(SQLException sqlex) {} 
			if (preparedstatement != null) try { preparedstatement.close(); } catch(SQLException sqlex) {} 
			if (connection != null) try { connection.close(); } catch(SQLException sqlex) {} 
		}
	}
		public void deleteActor(int ActorId) {			
			Connection connection = null;
			PreparedStatement preparedstatement = null;
			ResultSet resultset = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				
				connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
				preparedstatement = connection.prepareStatement("DELETE FROM actor WHERE actor_id=?");  
				preparedstatement.setInt(1, ActorId);  
				preparedstatement.executeUpdate();  
				
			}catch(ClassNotFoundException classex) {
				classex.printStackTrace();
			} catch(SQLException sqlex) {
				sqlex.printStackTrace();
			}finally { 
				if (resultset != null) try { resultset.close(); } catch(SQLException sqlex) {} 
				if (preparedstatement != null) try { preparedstatement.close(); } catch(SQLException sqlex) {} 
				if (connection != null) try { connection.close(); } catch(SQLException sqlex) {} 
			}
		}	
	public Actor updateActorForm(int actorId) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		Actor actor = new Actor();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		preparedstatement = connection.prepareStatement("SELECT * FROM actor WHERE actor_id=?");
		preparedstatement.setInt(1, actorId);
		resultset =preparedstatement.executeQuery();
		
		while(resultset.next()) {
			actor.setActorId(resultset.getInt("actor_id"));
			actor.setActorName(resultset.getString("actor_name"));
			actor.setActorAge(resultset.getInt("actor_age"));
		}
	}catch(ClassNotFoundException classex) {
		classex.printStackTrace();
	} catch(SQLException sqlex) {
		sqlex.printStackTrace();
	}finally { 
		if (resultset != null) try { resultset.close(); } catch(SQLException sqlex) {} 
		if (preparedstatement != null) try { preparedstatement.close(); } catch(SQLException sqlex) {} 
		if (connection != null) try { connection.close(); } catch(SQLException sqlex) {} 
	}
	return actor;	
}
	public void updateActorAction(int actorId, String actorName, int actorAge ) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement("update actor set actor_name=?,actor_age=? where actor_id=?");
			preparedstatement.setString(1, actorName);
			preparedstatement.setInt(2, actorAge);
			preparedstatement.setInt(3, actorId);
			
			preparedstatement.executeUpdate();
		}catch(ClassNotFoundException classex) {
			classex.printStackTrace();
		} catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}finally { 
			if (preparedstatement != null) try { preparedstatement.close(); } catch(SQLException sqlex) {} 
			if (connection != null) try { connection.close(); } catch(SQLException sqlex) {} 
			}
		}
	}


