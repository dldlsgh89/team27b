//27±â BÁ¶ ¹è°ÇÇý
package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActressDao {
	public ArrayList<Actress> selectActressList() {
		ArrayList<Actress> arrayActress = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";

			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement("SELECT actress_id,actress_name,actress_age FROM actress");
			resultset = preparedstatement.executeQuery();

			arrayActress = new ArrayList<Actress>();

			while (resultset.next()) {
				Actress actress = new Actress();
				actress.setActressId(Integer.parseInt(resultset.getString("actress_id")));
				actress.setActressName(resultset.getString("actress_name"));
				actress.setActressAge(resultset.getInt("actress_age"));
				arrayActress.add(actress);
			}
		} catch (ClassNotFoundException classex) {
			classex.getMessage();
			classex.printStackTrace();
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			if (resultset != null)try {resultset.close();} catch (SQLException sqlex) {}
			if (preparedstatement != null)try {preparedstatement.close();} catch (SQLException sqlex) {}
			if (connection != null)try {connection.close();} catch (SQLException sqlex) {}
		}
		return arrayActress;
	}

	public void insertActress(String actressName, int actressAge) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement("insert into actress values (0, ?, ?)");

			preparedstatement.setString(1, actressName);
			preparedstatement.setInt(2, actressAge);

			preparedstatement.executeUpdate();
		} catch (ClassNotFoundException classex) {
			classex.printStackTrace();
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			if (resultset != null)try {resultset.close();} catch (SQLException sqlex) {}
			if (preparedstatement != null)try {preparedstatement.close();} catch (SQLException sqlex) {}
			if (connection != null)try {connection.close();} catch (SQLException sqlex) {}
		}
	}

	public void deleteActress(int actressId) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";

			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement("DELETE FROM actress WHERE actress_id=?");
			preparedstatement.setInt(1, actressId);
			preparedstatement.executeUpdate();
		} catch (ClassNotFoundException classex) {
			classex.printStackTrace();
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			if (resultset != null)try {resultset.close();} catch (SQLException sqlex) {}
			if (preparedstatement != null)try {preparedstatement.close();} catch (SQLException sqlex) {}
			if (connection != null)
				try {connection.close();} catch (SQLException sqlex) {}
		}
	}

	public Actress updateActressForm(int actressId) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		Actress actress = new Actress();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";

			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement("SELECT * FROM actress WHERE actress_id=?");
			preparedstatement.setInt(1, actressId);
			resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				actress.setActressId(resultset.getInt("actress_id"));
				actress.setActressName(resultset.getString("actress_name"));
				actress.setActressAge(resultset.getInt("actress_age"));
			}
		} catch (ClassNotFoundException classex) {
			classex.printStackTrace();
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			if (resultset != null)try {resultset.close();} catch (SQLException sqlex) {}
			if (preparedstatement != null)try {preparedstatement.close();} catch (SQLException sqlex) {}
			if (connection != null)try {connection.close();} catch (SQLException sqlex) {}
		}
		return actress;
	}

	public void updateActressAction(int actressId, String actressName, int actressAge) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement("UPDATE actress set actress_name=?,actress_age=? WHERE actress_id=?");
			preparedstatement.setString(1, actressName);
			preparedstatement.setInt(2, actressAge);
			preparedstatement.setInt(3, actressId);

			preparedstatement.executeUpdate();
		} catch (ClassNotFoundException classex) {
			classex.printStackTrace();
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			if (preparedstatement != null) try {preparedstatement.close();} catch (SQLException sqlex) {}
			if (connection != null) try {connection.close();} catch (SQLException sqlex) {}
		}
	}
}
