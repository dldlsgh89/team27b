<!-- 27�� B�� �����  -->
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="services.ActorDao" %>
<%@ page import="services.Actor" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table width="100%" border="1">
	
	<tr>
		<th>���̵�</th>
		<th>�̸�</th>
		<th>����</th>
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
<a href="<%= request.getContextPath() %>/index.jsp">Ȩȭ��</a>
</body>
</html>