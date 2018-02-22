<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.ComedianDao" %>
<%@ page import ="services.Comedian" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String ComedianId = request.getParameter("ComedianId");
	ComedianDao cdao = new ComedianDao();
	Comedian com = cdao.comedianUpdateForm(Integer.parseInt(ComedianId));
	
%>

<div>
		<h1 style="text-align: center;">코미디언 수정양식</h1>
	</div>
		<form action = "<%= request.getContextPath() %>/comedian/comedianUpdateAction.jsp" method = "post">
			<input type="hidden" name="comedian_id" value="<%= com.getComedianId() %>">
			<table border="1">
				<thead>					
					<tr>
						<th>이름</th>
						<td><input type="text" name="comedian_name" value="<%= com.getComedianName() %>" size="20"></td>
					</tr>
					<tr>
						<th>나이</th>
						<td><input type="text" name="comedian_age" value="<%= com.getComedianAge() %>" size="20"></td>
					</tr>
						<tr style = "text-align: left;">
						<td><input type="submit" value="입력하기"></td>
					</tr>
				</thead>
			</table>
		</form>

</body>
</html>