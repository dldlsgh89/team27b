<!-- 27기 B조 배건혜  -->
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
		<h1 style="text-align: center;">남배우 정보 목록</h1>
	</div>
	<div style="width: 100%;">
		<div style="width: 85%; float: left;">
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
							href="<%=request.getContextPath()%>/actorUpdateForm.jsp?ActorId=<%=actor.getActorId()%>">수정</a></td>
						<td><a
							href="<%=request.getContextPath()%>/actorDeleteAction.jsp?ActorId=<%=actor.getActorId()%>">삭제</a></td>
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
					<td><a href="<%=request.getContextPath()%>/index.jsp">홈화면</a></td>
				</tr>
				<tr>
					<td><a
						href="<%=request.getContextPath()%>/actorInsertForm.jsp">남배우추가</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>