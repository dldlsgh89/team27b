<!-- 27기 B조 배건혜  -->
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
		<h1 style="text-align: center;">남배우 정보 목록</h1>
		</div>
		<div>
			<span style="padding: 0 1% 0 1%;">
				<a href="<%=request.getContextPath()%>/index.jsp" style="text-decoration: none;">홈화면</a>
			</span>
			<span style="padding: 0 1% 0 1%;">
				<a href="<%=request.getContextPath()%>/actor/actorInsertForm.jsp" style="text-decoration: none;">남배우추가</a>
			</span>
		</div>
		<hr>
		<div>
			<table style="width: 100%;" border="1">
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>나이</th>
						<th>수정</th>
						<th>삭제</th>
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
							href="<%=request.getContextPath()%>/actor/actorUpdateForm.jsp?ActorId=<%=actor.getActorId()%>">수정</a></td>
						<td><a
							href="<%=request.getContextPath()%>/actor/actorDeleteAction.jsp?ActorId=<%=actor.getActorId()%>">삭제</a></td>
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
		<h1 style="text-align: center;">남배우 정보 목록</h1>
	</div>
			<div>
				<span style="padding: 0 1% 0 1%;">
					<a href="<%=request.getContextPath()%>/index.jsp" style="text-decoration: none;">홈화면</a>
				</span>
			</div>
			<hr>
		<div>
			<table style="width: 100%;" border="1">
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>나이</th>
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