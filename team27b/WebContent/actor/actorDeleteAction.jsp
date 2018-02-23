<!-- 27기B조 배건혜 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.ActorDao"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		int actorId = Integer.parseInt(request.getParameter("ActorId"));
		ActorDao actorDao = new ActorDao();
		actorDao.deleteActor(actorId);
		response.sendRedirect(request.getContextPath() + "/actor/actorList.jsp");
	%>
</body>
</html>