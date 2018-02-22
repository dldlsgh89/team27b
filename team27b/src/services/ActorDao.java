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
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&charaterEncoding=euckr";
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
		}catch(ClassNotFoundException e) {
			e.getMessage();
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
	
	public void insertActor(Actor actor) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&charaterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement("insert into actor values (0, ?, ?)");
			
			preparedstatement.setString(1, actor.getActorName());
			preparedstatement.setInt(2, actor.getActorAge());
			
			preparedstatement.executeUpdate();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally { 
			if (resultset != null) try { resultset.close(); } catch(SQLException e) {} 
			if (preparedstatement != null) try { preparedstatement.close(); } catch(SQLException e) {} 
			if (connection != null) try { connection.close(); } catch(SQLException e) {} 
		}
	}
		public void deleteActor(int ActorId) {			
			Connection connection = null;
			PreparedStatement preparedstatement = null;
			ResultSet resultset = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&charaterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				
				connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
				preparedstatement = connection.prepareStatement("DELETE FROM actor WHERE actor_id=?");  
				preparedstatement.setInt(1, ActorId);  
				preparedstatement.executeUpdate();  
				
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch(SQLException e) {
				e.printStackTrace();
			}finally { 
				if (resultset != null) try { resultset.close(); } catch(SQLException e) {} 
				if (preparedstatement != null) try { preparedstatement.close(); } catch(SQLException e) {} 
				if (connection != null) try { connection.close(); } catch(SQLException e) {} 
			}
		}	
	
	}
	


