<!-- //27기 B조 이인호 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import= "services.Anaunseo" %>
<%@ page import = "services.AnaunseoDao" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1 style="text-align: center;">아나운서 정보 목록</h1>
	</div>
	<div>
		<span style="padding: 0 1% 0 1%;">
			<a href="<%= request.getContextPath() %>/index.jsp" style="text-decoration: none;">홈화면</a>
		</span>
		<span style="padding: 0 1% 0 1%;">
			<a href="<%= request.getContextPath() %>/anaunseo/anaunseoInsertForm.jsp" style="text-decoration: none;">아나운서추가</a>
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
		<!-- 테이블 윗부분에서 각 칼럼위치의 제목을 먼저 잡아준다 -->
	
	<%
		AnaunseoDao Ado = new AnaunseoDao();
		ArrayList<Anaunseo> ArrayAna = Ado.selectAnaunseoList();		
		for(int i = 0; i<ArrayAna.size(); i++){
			Anaunseo Ana = ArrayAna.get(i);			
			//
	%>
				<tbody>	
					<tr>
						<td><%= Ana.getAnaunseoId()%></td>
						<td><%= Ana.getAnaunseoName()%></td>
						<td><%= Ana.getAnaunseoAge()%></td>	
						<td><a href="<%= request.getContextPath() %>/anaunseo/anaunseoUpdateForm.jsp?AnaunseoId=<%=Ana.getAnaunseoId()%>">아나운서수정</a></td>
						<td><a href="<%= request.getContextPath() %>/anaunseo/anaunseoDeleteAction.jsp?AnaunseoId=<%=Ana.getAnaunseoId()%>">아나운서삭제</a></td>		
					</tr>
				</tbody>									
	<%
			}
	%>
		</table>	
		</div>
</body>
</html>
