<!-- 27기 B조 배건헤  -->
<%@ page import = "services.Actress" %>
<%@ page import = "services.ActressDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<div>
			<h1 style="text-align: center;">여배우 정보 목록</h1>
	</div>
		<div style="width: 100%;">
			<div style="width: 85%; float: left;">
				<table style="width: 100%;" border="1">
					<thead>
						<tr>
						<th>아이디</th><th>이름</th><th>나이</th>
						</tr>
					</thead>
 <%
 		ActressDao actressDao = new ActressDao();
 		ArrayList<Actress> arrayActress = actressDao.selectActressList();
 		for(int i = 0; i<arrayActress.size(); i++){
 			Actress actress = arrayActress.get(i);
%>	
		<tbody>
			<tr>
				<td><%= actress.getActressId() %></td>
				<td><%= actress.getActressName()  %></td>
				<td><%= actress.getActressAge() %></td>
			</tr>
		</tbody>	
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
					<td><a href="<%= request.getContextPath() %>/actressInsertForm.jsp">여배우추가</a></td>
				</tr>
				<tr>
					<td><a href="<%= request.getContextPath() %>/index.jsp">여배우수정</a></td>
				</tr>
				<tr>
					<td><a href="<%= request.getContextPath() %>/index.jsp">여배우삭제</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>					