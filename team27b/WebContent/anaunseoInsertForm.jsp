<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1 style="text-align: center;">아나운서 가입양식</h1>
	</div>
		<form action = "<%= request.getContextPath() %>/anaunseoInsertJoin.jsp" method = "post">
			<table border="1">
				<thead>					
					<tr>
						<th>이름</th>
						<td><input type="text" name="anaunseo_name" size="20"></td>
					</tr>
					<tr>
						<th>나이</th>
						<td><input type="text" name="anaunseo_age" size="20"></td>
					</tr>
						<tr style = "text-align: left;">
						<td><input type="submit" value="입력하기"></td>
					</tr>
				</thead>
			</table>
		</form>

</body>
</html>