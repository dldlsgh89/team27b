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
	
	<table width="100%" border="1">
		<tr>
		<th>아이디</th><th>이름</th><th>나이</th>
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

