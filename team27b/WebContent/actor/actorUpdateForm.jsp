<!-- 27기B조 배건혜 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import ="services.Actor" %>
<%@ page import ="services.ActorDao" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>actorUpdateForm</title>
</head>
<body>
<%
String actorId = request.getParameter("actor_id");
ActorDao actorDao = new ActorDao();
Actor actor = actorDao.updateActorForm(Integer.parseInt(actorId));
%>
<div>
		<h1 style="text-align: center;">남배우 수정양식</h1>
	</div>
	<form action="<%=request.getContextPath()%>/actor/actorUpdateAction.jsp" method="post">
		<input type="hidden" name= "actor_id" value="<%= actor.getActorId()%>">
		<table style="margin: 0 auto; "1">
			<thead>
				<tr>
					<td>이름</td>
					<td><input type="text" name="actor_name" value="<%=actor.getActorName() %>" size="20"></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="actor_age" value="<%=actor.getActorAge() %>" size="20"></td>
				</tr>
				<tr style="text-align: left;">
					<td><input type="submit" value="수정버튼"></td>
				</tr>
			</thead>
		</table>
	</form>
</body>
</html>