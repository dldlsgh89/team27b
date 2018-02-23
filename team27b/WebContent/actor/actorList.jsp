<!-- 27�� B�� �����  -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.ActorDao"%>
<%@ page import="services.Actor"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>actorList</title>
</head>
<body>
	<%
	String S_ID = (String)session.getAttribute("S_ID");
	
	if(S_ID != null){
	%>
		<div>
		<h1 style="text-align: center;">����� ���� ���</h1>
		</div>
		<div>
			<span style="padding: 0 1% 0 1%;">
				<a href="<%=request.getContextPath()%>/index.jsp" style="text-decoration: none;">Ȩȭ��</a>
			</span>
			<span style="padding: 0 1% 0 1%;">
				<a href="<%=request.getContextPath()%>/actor/actorInsertForm.jsp" style="text-decoration: none;">������߰�</a>
			</span>
		</div>
		<hr>
		<div>
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
							href="<%=request.getContextPath()%>/actor/actorUpdateForm.jsp?ActorId=<%=actor.getActorId()%>">����</a></td>
						<td><a
							href="<%=request.getContextPath()%>/actor/actorDeleteAction.jsp?ActorId=<%=actor.getActorId()%>">����</a></td>
					</tr>
				</tbody>
				<%
					}
				%>
			</table>
		</div>
	<%
	}else{
	%>
		<div>
		<h1 style="text-align: center;">����� ���� ���</h1>
	</div>
			<div>
				<span style="padding: 0 1% 0 1%;">
					<a href="<%=request.getContextPath()%>/index.jsp" style="text-decoration: none;">Ȩȭ��</a>
				</span>
			</div>
			<hr>
		<div>
			<table style="width: 100%;" border="1">
				<thead>
					<tr>
						<th>���̵�</th>
						<th>�̸�</th>
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
					</tr>
				</tbody>
				<%
					}
				%>
			</table>
		</div>
	<%
	}
	%>
</body>
</html>