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
	request.setCharacterEncoding("EUC-KR");
	int singerId = Integer.parseInt(request.getParameter("singer_id"));
	String singerName = request.getParameter("singer_name");
	int singerAge = Integer.parseInt(request.getParameter("singer_age"));

	Singer singer = new Singer();
	singer.setSingerId(singerId);
	singer.setSingerName(singerName);
	singer.setSingerAge(singerAge);
	
	SingerDao singerDao = new SingerDao();
	singerDao.updateActionSinger(singer);
	
	response.sendRedirect(request.getContextPath()+"/singer/singerList.jsp");
	%>
</body>
</html>