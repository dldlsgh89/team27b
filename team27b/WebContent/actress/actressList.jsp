<!-- 27기 B조 배건헤  -->
<%@ page import="services.Actress"%>
<%@ page import="services.ActressDao"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>actressList</title>
</head>
<body>
<%
	String S_ID = (String)session.getAttribute("S_ID");
	
	if(S_ID != null){
	%>
		<div>
		<h1 style="text-align: center;">여배우 정보 목록</h1>
	</div>
	<div>
				<span style="padding: 0 1% 0 1%;">
				<a href="<%=request.getContextPath()%>/index.jsp" style="text-decoration: none;">홈화면</a></td>
				</span>
				
				
				<span style="padding: 0 1% 0 1%;">
					<a href="<%=request.getContextPath()%>/actress/actressInsertForm.jsp" style="text-decoration: none;">여배우추가</a>
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
					ActressDao actressDao = new ActressDao();
					ArrayList<Actress> arrayActress = actressDao.selectActressList();
					for (Actress actress : arrayActress) {
						
				%>
				<tbody>
					<tr>
						<td><%=actress.getActressId()%></td>
						<td><%=actress.getActressName()%></td>
						<td><%=actress.getActressAge()%></td>
						<td><a
							href="<%=request.getContextPath()%>/actress/actressUpdateForm.jsp?ActressId=<%=actress.getActressId()%>">수정</a></td>
						<td><a
							href="<%=request.getContextPath()%>/actress/actressDeleteAction.jsp?ActressId=<%=actress.getActressId()%>">삭제</a></td>
					</tr>
				</tbody>
				<%
					}
				%>
			</table>
		</div>
	<%
	}else{
	%>
		<div>
		<h1 style="text-align: center;">여배우 정보 목록</h1>
	</div>
	<div>
				<span style="padding: 0 1% 0 1%;">
				<a href="<%=request.getContextPath()%>/index.jsp" style="text-decoration: none;">홈화면</a></td>
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
			<%
				ActressDao actressDao = new ActressDao();
				ArrayList<Actress> arrayActress = actressDao.selectActressList();
				for (Actress actress : arrayActress) {
					
			%>
			<tbody>
				<tr>
					<td><%=actress.getActressId()%></td>
					<td><%=actress.getActressName()%></td>
					<td><%=actress.getActressAge()%></td>
				</tr>
			</tbody>
			<%
				}
			%>
		</table>
	</div>
<%
}
%>
	
</body>
</html>
