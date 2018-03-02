<!-- 27기 b조 나성수 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.Singer" %>
<%@ page import="services.SingerDao" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("EUC-KR");
	String singerName = request.getParameter("singer_name");
	int singerAge = Integer.parseInt(request.getParameter("singer_age"));
	
	SingerDao singerDao = new SingerDao();
	singerDao.insertSinger(singerName, singerAge);
	
	response.sendRedirect(request.getContextPath()+"/singer/singerList.jsp");
	%>
</body>
</html>