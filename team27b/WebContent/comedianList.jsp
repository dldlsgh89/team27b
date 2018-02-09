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
	<div>
		<h1 style="text-align: center;">코미디언 정보 목록</h1>
	</div>
	<div style="width: 100%;">
		<div style="width: 85%; float: left;">
			<table style="width: 100%;" border="1">
				<tr>
				<th>아이디</th><th>이름</th><th>나이</th>
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
		</div>
		<div style="float:left;">
			<table>
				<tr>
					<td><a href="<%= request.getContextPath() %>/index.jsp">홈화면</a></td>
				</tr>
				<tr>
					<td><a href="<%= request.getContextPath() %>/index.jsp">코미디언추가</a></td>
				</tr>
				<tr>
					<td><a href="<%= request.getContextPath() %>/index.jsp">코미디언수정</a></td>
				</tr>
				<tr>
					<td><a href="<%= request.getContextPath() %>/index.jsp">코미디언삭제</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>