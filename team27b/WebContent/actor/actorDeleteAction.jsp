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
		int ActorId = Integer.parseInt(request.getParameter("ActorId"));
		ActorDao actorDao = new ActorDao();
		actorDao.deleteActor(ActorId);
		response.sendRedirect(request.getContextPath() + "/actor/actorList.jsp");
	%>
</body>
</html>