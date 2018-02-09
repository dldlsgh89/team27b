<!-- //27기 B조 이인호 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "services.ComedianDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "services.Comedian" %>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	comedianList.jsp<br>

<table width=100% border="1">
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>나이</td>
	</tr>



<%
	ComedianDao	Cdo = new ComedianDao();

	ArrayList<Comedian> ArrayCom = Cdo.SelectComedianList();
	
		for(Comedian com : ArrayCom){
%>	
			<tr>
				<td><%= com.getComedianid() %></td>
				<td><%= com.getComedianname() %></td>
				<td><%= com.getComedianage() %></td>
			</tr>
<%
		}
%>
</table>
</body>
</html>