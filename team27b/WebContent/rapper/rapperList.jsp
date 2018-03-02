<!-- 27기 b조 나성수 -->

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
	<%
	String S_ID = (String)session.getAttribute("S_ID");
	
	if(S_ID != null){
	%>
		<div>
			<h1 style="text-align: center;">랩퍼 정보 목록</h1>
		</div>
		<div>
			<span style="padding: 0 1% 0 1%;">
				<a href="<%= request.getContextPath() %>/index.jsp" style="text-decoration: none;">홈화면</a>
			</span>
			<span style="padding: 0 1% 0 1%;">
				<a href="<%= request.getContextPath() %>/rapper/rapperInsertForm.jsp" style="text-decoration: none;">랩퍼추가</a>
			</span>
		</div>
		<hr>
		<div>
			<table style="width: 100%;" border="1">
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>나이</th>
						<th>수정</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<%
					RapperDao rapperDao = new RapperDao();
					ArrayList<Rapper> arrayRapper = rapperDao.selectRapperList();
					
					for(Rapper rapper : arrayRapper){
					%>
						<tr>
							<td><%= rapper.getRapperId() %></td>
							<td><%= rapper.getRapperName() %></td>
							<td><%= rapper.getRapperAge() %></td>
							<td><a href="<%=request.getContextPath()%>/rapper/rapperUpdateForm.jsp?RapperId=<%=rapper.getRapperId()%>" style="text-decoration: none;">수정</a></td>
							<td><a href="<%=request.getContextPath()%>/rapper/rapperDeleteAction.jsp?RapperId=<%=rapper.getRapperId()%>" style="text-decoration: none;">삭제</a></td>
						</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
		<%
	}else{
	%>
		<div>
			<h1 style="text-align: center;">랩퍼 정보 목록</h1>
		</div>
		<div>
			<span style="padding: 0 1% 0 1%;">
				<a href="<%= request.getContextPath() %>/index.jsp" style="text-decoration: none;">홈화면</a>
			</span>
		</div>
		<hr>
		<div>
			<table style="width: 100%;" border="1">
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>나이</th>
					</tr>
				</thead>
				<tbody>
					<%
					RapperDao rapperDao = new RapperDao();
					ArrayList<Rapper> arrayRapper = rapperDao.selectRapperList();
					
					for(Rapper rapper : arrayRapper){
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
	<%
	}
	%>
</body>
</html>
