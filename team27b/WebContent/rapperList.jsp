<!-- 나성수 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.RapperDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="services.Repper" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	singerList.jsp<br>
	
	<table border="1">
		<tr>
		<th>singer_id</th><th>singer_name</th><th>singer_age</th>
		</tr>
		
		<%
		RapperDao rapperDao = new RapperDao();
		ArrayList<Repper> list = rapperDao.selectRepperList();
		
		for(Repper repper : list){
		%>
			<tr>
			<td><%= repper.getRepperId() %></td>
			<td><%= repper.getRepperName() %></td>
			<td><%= repper.getRepperAge() %></td>
			</tr>
		<%
		}
		%>
	</table>
</body>
</html>
