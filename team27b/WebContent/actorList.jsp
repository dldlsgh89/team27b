<!-- 27�� B�� �����  -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.ActorDao"%>
<%@ page import="services.Actor"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1 style="text-align: center;">����� ���� ���</h1>
	</div>
	<div style="width: 100%;">
		<div style="width: 85%; float: left;">
			<table style="width: 100%;" border="1">
				<thead>
					<tr>
						<th>���̵�</th>
						<th>�̸�</th>
						<th>����</th>
						<th>����</th>
						<th>����</th>
					</tr>
				</thead>
				<%
					ActorDao actorDao = new ActorDao();
					ArrayList<Actor> arrayActor = actorDao.selectActorList();
					for (Actor actor : arrayActor) {
						
				%>
				<tbody>
					<tr>
						<td><%=actor.getActorId()%></td>
						<td><%=actor.getActorName()%></td>
						<td><%=actor.getActorAge()%></td>
						<td><a
							href="<%=request.getContextPath()%>/actorUpdateForm.jsp?ActorId=<%=actor.getActorId()%>">����</a></td>
						<td><a
							href="<%=request.getContextPath()%>/actorDeleteAction.jsp?ActorId=<%=actor.getActorId()%>">����</a></td>
					</tr>
				</tbody>
				<%
					}
				%>
			</table>
		</div>
		<div style="float: left;">
			<table>
				<tr>
					<td><a href="<%=request.getContextPath()%>/index.jsp">Ȩȭ��</a></td>
				</tr>
				<tr>
					<td><a
						href="<%=request.getContextPath()%>/actorInsertForm.jsp">������߰�</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>