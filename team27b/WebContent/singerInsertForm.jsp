<!-- 나성수 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center;">가수 가입양식</h1>
	<hr>
	<form action = "<%= request.getContextPath() %>/singerInsertJoin.jsp" method = "post">
		<table border="1" style="margin: 0 auto;">
			<tbody>
				<tr>
				<td>이름</td>
				<td><input type="text" name="singer_name" size="20"></td>
				</tr>
				<tr>
				<td>나이</td>
				<td><input type="text" name="singer_age" size="20"></td>
				</tr>
				<tr>
				<td><input type="submit" value="입력하기"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>