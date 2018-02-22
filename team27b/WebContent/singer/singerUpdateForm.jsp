<!-- 나성수 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.SingerDao" %>
<%@ page import="services.Singer" %>
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
	int singerId = Integer.parseInt(request.getParameter("SingerId"));
	
	SingerDao singerDao = new SingerDao();
	Singer singer = singerDao.updateFormSinger(singerId);
	%>
	<form action = "<%= request.getContextPath() %>/singer/singerUpdateAction.jsp" method = "post">
		<input type="hidden" name="singer_id" value="<%=singer.getSingerId()%>">
		<table border="1" style="margin: 0 auto;">
			<tbody>
				<tr>
					<td>이름</td>
					<td><input type="text" name="singer_name" value="<%=singer.getSingerName() %>" size="20"></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="singer_age" value="<%=singer.getSingerAge() %>" size="20"></td>
				</tr>
				<tr>
					<td colspan="2" style="padding: 0 0 0 33%;"><input type="submit" value="수정하기"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>