package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ActorDao {

	/*public ActorDao() {
		public ArrayList<Actor> selectActorList(){
			ArrayList<Actor> arrayActor = null;
			PreparedStatement preparedstatement = null;
			ResultSet resultset = null;
			Connection connection = null;
			
			try {
				Class.forName("com.mysqsl.jdbc.Driver");
				String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&charaterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				
				connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass); 
				preparedstatement = connection.prepareStatement("select Actor_id,Actor_name,Actor_age from Actor");
				resultset = preparedstatement.executeQuery();
				
				arrayActor = new ArrayList<Actor>();
				while(resultset.next()) {
					Actor actor = new Actor();
					String ActorId = resultset.getString("actorId");
					String ActorName = resultset.getString("actorName");
					String ActorAge = resultset.getString("actorAge");
					
					actor.setActorId(Integer.parseInt(ActorId));
					actor.setActorName(ActorName);
					actor.setActorAge(Integer.parseInt(ActorAge));
					arrayActor.add(actor);
							
				}
				
			}catch() {
				
			}
		}
	}*/
}

