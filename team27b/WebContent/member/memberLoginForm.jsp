<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	String S_ID = (String)session.getAttribute("S_ID");
	
	if(S_ID != null){
	%>
		<br><br><%=S_ID%>�� ȯ���մϴ�
		<a href="<%=request.getContextPath()%>/member/memberLogout.jsp">�α׾ƿ�</a>
	<%
	}else{
	%>
	<form action="<%=request.getContextPath()%>/member/memberLoginAction.jsp" method="post">
		<table>
			<tbody>
				<tr>
					<td>���̵�</td>
					<td><input type="text" name="memberId"></td>
				</tr>
				<tr>
					<td>��й�ȣ</td>
					<td><input type="password" name="memberPw"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="�α���"></td>
				</tr>
			</tbody>
		</table>
	</form>
	<%
	}
	%>
</body>
</html>