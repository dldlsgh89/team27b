<!--27기 B조 배건혜  -->
<%@page import="services.ActressDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		int actressId = Integer.parseInt(request.getParameter("ActressId"));
		ActressDao actressDao = new ActressDao();
		actressDao.deleteActress(actressId);
		response.sendRedirect(request.getContextPath() + "/actress/actressList.jsp");
	%>
</body>
</html>