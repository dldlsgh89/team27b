<!-- 나성수 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.RapperDao" %>
<%@ page import="services.Rapper" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center;">랩퍼 수정양식</h1>
	<hr>
	<%
	int rapperId = Integer.parseInt(request.getParameter("RapperId"));
	
	RapperDao rapperDao = new RapperDao();
	Rapper rapper = rapperDao.updateRapperForm(rapperId);
	%>
	<form action = "<%= request.getContextPath() %>/rapper/rapperUpdateAction.jsp" method = "post">
		<input type="hidden" name="rapper_id" value="<%=rapper.getRapperId()%>">
		<table border="1" style="margin: 0 auto;">
			<tbody>
				<tr>
					<td>이름</td>
					<td><input type="text" name="rapper_name" value="<%=rapper.getRapperName() %>" size="20"></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="rapper_age" value="<%=rapper.getRapperAge() %>" size="20"></td>
				</tr>
				<tr>
					<td colspan="2" style="padding: 0 0 0 33%;"><input type="submit" value="수정"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>