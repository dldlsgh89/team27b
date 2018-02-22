<!-- 나성수 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.Rapper" %>
<%@ page import="services.RapperDao" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("EUC-KR");
	int rapperId = Integer.parseInt(request.getParameter("rapper_id"));
	String rapperName = request.getParameter("rapper_name");
	int rapperAge = Integer.parseInt(request.getParameter("rapper_age"));

	Rapper rapper = new Rapper();
	rapper.setRapperId(rapperId);
	rapper.setRapperName(rapperName);
	rapper.setRapperAge(rapperAge);
	
	RapperDao rapperDao = new RapperDao();
	rapperDao.updateActionRapper(rapper);
	
	response.sendRedirect(request.getContextPath()+"/rapper/rapperList.jsp");
	%>
</body>
</html>