<!-- 나성수 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="services.SingerDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="services.Singer" %>
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
		SingerDao singerDao = new SingerDao();
		ArrayList<Singer> list = singerDao.selectSingerList();
		
		for(Singer singer : list){
		%>
			<tr>
			<td><%= singer.getSingerId() %></td>
			<td><%= singer.getSingerName() %></td>
			<td><%= singer.getSingerAge() %></td>
			</tr>
		<%
		}
		%>
	</table>
</body>
</html>

