<!-- 나성수 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.RapperDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="services.Rapper" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	rapperList.jsp<br>
	
	<table width="100%" border="1">
		<tr>
		<th>아이디</th><th>이름</th><th>나이</th>
		</tr>
		
		<%
		RapperDao rapperDao = new RapperDao();
		ArrayList<Rapper> list = rapperDao.selectRapperList();
		
		for(Rapper rapper : list){
		%>
			<tr>
			<td><%= rapper.getRapperId() %></td>
			<td><%= rapper.getRapperName() %></td>
			<td><%= rapper.getRapperAge() %></td>
			</tr>
		<%
		}
		%>
	</table>
</body>
</html>
