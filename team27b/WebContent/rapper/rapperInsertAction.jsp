<!-- ������ -->

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
	request.setCharacterEncoding("euckr");
	String rapperName = request.getParameter("rapper_name");
	String rapperAge = request.getParameter("rapper_age");
	
	Rapper rapper = new Rapper();
	rapper.setRapperName(rapperName);
	rapper.setRapperAge(Integer.parseInt(rapperAge));
	
	RapperDao rapperDao = new RapperDao();
	rapperDao.insertRapper(rapper);
	
	response.sendRedirect(request.getContextPath()+"/rapperList.jsp");
	%>
</body>
</html>