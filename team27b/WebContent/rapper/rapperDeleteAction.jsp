<!-- 나성수 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.RapperDao" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	int rapperId=Integer.parseInt(request.getParameter("RapperId"));
	
	RapperDao rapperDao = new RapperDao();
	rapperDao.deleteRapper(rapperId);
	
	response.sendRedirect(request.getContextPath()+"/rapper/rapperList.jsp");
	%>
</body>
</html>