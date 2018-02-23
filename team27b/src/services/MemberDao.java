package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	public Member memberLogin(Member member) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		Member member2 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedstatement = connection.prepareStatement("SELECT * FROM member WHERE member_id=?");
			preparedstatement.setString(1, member.getMemberId());
			
			resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				System.out.println("���̵� ��ġ");
				if(resultset.getString("member_pw").equals(member.getMemberPw())) {
					System.out.println("�α��� ����");
					member2 = new Member();
					member2.setMemberId(resultset.getString("member_id"));
					member2.setMemberNo(Integer.parseInt(resultset.getString("member_no")));
					member2.setMemberPw(resultset.getString("member_pw"));
				}else {
					System.out.println("��� ����ġ");
				}
			}else {
				System.out.println("���̵� ����ġ");
			}
		}catch(SQLException sqlex) {
			sqlex.getStackTrace();
		}catch(ClassNotFoundException classex){
			classex.getStackTrace();
		}finally {
			if(resultset == null) try {resultset.close();}catch(SQLException sqlex){}
			if(preparedstatement == null) try {resultset.close();}catch(SQLException sqlex){}
			if(connection == null) try {resultset.close();}catch(SQLException sqlex){}
		}
		
		
		return member2;
	}
}
