<!-- //27기 B조 이인호 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "services.ComedionDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "services.Comedion" %>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	comedionList.jsp<br>

<table width=100% border="1">
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>나이</td>
	</tr>



<%
	ComedionDao	Cdo = new ComedionDao();

	ArrayList<Comedion> ArrayCom = Cdo.SelectComedionList();
	
		for(Comedion com : ArrayCom){
%>	
			<tr>
				<td><%= com.getComedionid() %></td>
				<td><%= com.getComedionname() %></td>
				<td><%= com.getComedionage() %></td>
			</tr>
<%
		}
%>
</table>
</body>
</html>