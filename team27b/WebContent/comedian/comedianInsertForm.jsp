<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center;">�ڹ̵�� ���Ծ��</h1>
	<hr>
	<form action = "<%= request.getContextPath() %>/comedian/comedianInsertAction.jsp" method = "post">
		<table border="1" style="margin: 0 auto;">
			<thead>						
				<tr>
					<th>�̸�</th>
					<td><input type="text" name="comedian_name" size="20"></td>
				</tr>
				<tr>
					<th>����</th>
					<td><input type="text" name="comedian_age" size="20"></td>
				</tr>
				<tr>
					<td colspan="2" style="padding: 0 0 0 33%;"><input type="submit" value="�Է��ϱ�"></td>
				</tr>
			</thead>
		</table>
	</form>
</body>
</html>

<!-- 
						<tr><input type="hidden" name="comedian_id" size="20"></tr> -->
					