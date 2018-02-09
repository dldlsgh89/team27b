<!-- 27기 B조 배건혜  -->
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="services.ActorDao" %>
<%@ page import="services.Actor" %>
<!DOCTYPE html>
<html>
<body>
<table width="100%" border="1">
	
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>나이</th>
	</tr>
	<%
	ActorDao actorDao = new ActorDao();
	ArrayList<Actor> list = actorDao.selectActorList();
	for (Actor actor : list) {
	%>
		<tr>
			<td><%= actor.getActorId() %></td>
			<td><%= actor.getActorName() %></td>
			<td><%= actor.getActorAge() %></td>
		</tr>
	<%
	}
	%>
</table>
</body>
</html>