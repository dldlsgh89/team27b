<!--27�� B�� �����  -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1 style="text-align: center;">����� ���Ծ��</h1>
	</div>

	<form action="<%=request.getContextPath()%>/actressInsertJoin.jsp method="post">
		<table border="1">
			<thead>

				<tr>
					<th>�̸�</th>
					<td><input type="text" name="actress_name" size="20"></td>
				</tr>
				<tr>
					<th>����</th>
					<td><input type="text" name="actress_age" size="20"></td>
				</tr>
				<tr style="text-align: left;">
					<td><input type="submit" value="�Է��ϱ�"></td>
				</tr>
			</thead>
		</table>
	</form>
</body>
</html>