<!-- 27기 b조 나성수 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center;">랩퍼 가입양식</h1>
	<hr>
	<form action = "<%= request.getContextPath() %>/rapper/rapperInsertAction.jsp" method = "post">
		<table border="1" style="margin: 0 auto;">
			<tbody>
				<tr>
					<td>이름</td>
					<td><input type="text" name="rapper_name" size="20"></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="rapper_age" size="20"></td>
				</tr>
				<tr>
					<td colspan="2" style="padding: 0 0 0 33%;"><input type="submit" value="입력하기"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>