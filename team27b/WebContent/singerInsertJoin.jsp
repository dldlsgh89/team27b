<!-- 나성수 -->

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
	request.setCharacterEncoding("euckr");
	String singerName = request.getParameter("singer_name");
	String singerAge = request.getParameter("singer_age");
	
	Singer singer = new Singer();
	singer.setSingerName(singerName);
	singer.setSingerAge(Integer.parseInt(singerAge));
	
	SingerDao singerDao = new SingerDao();
	singerDao.insertSinger(singer);
	
	response.sendRedirect(request.getContextPath()+"/singerList.jsp");
	%>
</body>
</html>