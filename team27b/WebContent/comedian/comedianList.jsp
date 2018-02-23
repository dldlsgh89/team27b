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
	<div>
		<span style="padding: 0 1% 0 1%;">
			<a href="<%= request.getContextPath() %>/index.jsp" style="text-decoration: none;">홈화면</a>
		</span>
		<span style="padding: 0 1% 0 1%;">
			<a href="<%= request.getContextPath() %>/comedian/comedianInsertForm.jsp" style="text-decoration: none;">코미디언추가</a>
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
	<%
		ComedianDao	comedianDao = new ComedianDao();	
		ArrayList<Comedian> arrayComedian = comedianDao.selectComedianList();		
		for(Comedian comedian : arrayComedian){
	%>	
				<tbody>
					<tr>
						<td><%= comedian.getComedianId() %></td>
						<td><%= comedian.getComedianName() %></td>
						<td><%= comedian.getComedianAge() %></td>
						<td><a href="<%= request.getContextPath() %>/comedian/comedianUpdateForm.jsp?ComedianId=<%=comedian.getComedianId()%>">수정</a></td>
						<td><a href="<%= request.getContextPath() %>/comedian/comedianDeleteAction.jsp?ComedianId=<%=comedian.getComedianId()%>">삭제</a></td>	
					</tr>
				</tbody>	
	<%
		}
	%>
			</table>
		</div>
</body>
</html>