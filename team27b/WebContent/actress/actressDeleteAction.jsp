<%@page import="services.ActressDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
int ActressId = Integer.parseInt(request.getParameter("ActressId"));
ActressDao actressDao = new ActressDao();
actressDao.deleteActress(ActressId);
response.sendRedirect(request.getContextPath()+"/actress/actressList.jsp");
%>
</body>
</html>