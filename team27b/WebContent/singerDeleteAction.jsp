<!-- 나성수 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.SingerDao" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	int singerId=Integer.parseInt(request.getParameter("SingerId"));
	
	SingerDao singerDao = new SingerDao();
	singerDao.deleteSinger(singerId);
	
	response.sendRedirect(request.getContextPath()+"/singerList.jsp");
	%>
</body>
</html>