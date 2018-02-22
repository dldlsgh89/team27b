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
	<h1 style="text-align: center;">랩퍼 정보 목록</h1>
	<hr>
	<div style="width: 100%;">
		<div style="width: 90%; float: left;">
			<table style="width: 100%;" border="1">
				<thead>
					<tr>
					<th>아이디</th><th>이름</th><th>나이</th>
					</tr>
				</thead>
				<tbody>
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
				</tbody>
			</table>
		</div>
		<div style="float:left;">
			<table>
				<tr>
					<td><a href="<%= request.getContextPath() %>/index.jsp">홈화면</a></td>
				</tr>
				<tr>
					<td><a href="<%= request.getContextPath() %>/index.jsp">랩퍼추가</a></td>
				</tr>
				<tr>
					<td><a href="<%= request.getContextPath() %>/index.jsp">랩퍼수정</a></td>
				</tr>
				<tr>
					<td><a href="<%= request.getContextPath() %>/index.jsp">랩퍼삭제</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
