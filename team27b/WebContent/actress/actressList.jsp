<!-- 27�� B�� �����  -->
<%@ page import="services.Actress"%>
<%@ page import="services.ActressDao"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>actressList</title>
</head>
<body>
<%
	String S_ID = (String)session.getAttribute("S_ID");
	
	if(S_ID != null){
	%>
		<div>
		<h1 style="text-align: center;">����� ���� ���</h1>
	</div>
	<div>
				<span style="padding: 0 1% 0 1%;">
				<a href="<%=request.getContextPath()%>/index.jsp" style="text-decoration: none;">Ȩȭ��</a></td>
				</span>
				
				
				<span style="padding: 0 1% 0 1%;">
					<a href="<%=request.getContextPath()%>/actress/actressInsertForm.jsp" style="text-decoration: none;">������߰�</a>
				</span>		
		</div>
		<hr>
		<div>
			<table style="width: 100%;" border="1">
				<thead>
					<tr>
						<th>���̵�</th>
						<th>�̸�</th>
						<th>����</th>
						<th>����</th>
						<th>����</th>
					</tr>
				</thead>
				<%
					ActressDao actressDao = new ActressDao();
					ArrayList<Actress> arrayActress = actressDao.selectActressList();
					for (Actress actress : arrayActress) {
						
				%>
				<tbody>
					<tr>
						<td><%=actress.getActressId()%></td>
						<td><%=actress.getActressName()%></td>
						<td><%=actress.getActressAge()%></td>
						<td><a
							href="<%=request.getContextPath()%>/actress/actressUpdateForm.jsp?ActressId=<%=actress.getActressId()%>">����</a></td>
						<td><a
							href="<%=request.getContextPath()%>/actress/actressDeleteAction.jsp?ActressId=<%=actress.getActressId()%>">����</a></td>
					</tr>
				</tbody>
				<%
					}
				%>
			</table>
		</div>
	<%
	}else{
	%>
		<div>
		<h1 style="text-align: center;">����� ���� ���</h1>
	</div>
	<div>
				<span style="padding: 0 1% 0 1%;">
				<a href="<%=request.getContextPath()%>/index.jsp" style="text-decoration: none;">Ȩȭ��</a></td>
				</span>
	</div>
	<hr>
	<div>
		<table style="width: 100%;" border="1">
			<thead>
				<tr>
					<th>���̵�</th>
					<th>�̸�</th>
					<th>����</th>
				</tr>
			</thead>
			<%
				ActressDao actressDao = new ActressDao();
				ArrayList<Actress> arrayActress = actressDao.selectActressList();
				for (Actress actress : arrayActress) {
					
			%>
			<tbody>
				<tr>
					<td><%=actress.getActressId()%></td>
					<td><%=actress.getActressName()%></td>
					<td><%=actress.getActressAge()%></td>
				</tr>
			</tbody>
			<%
				}
			%>
		</table>
	</div>
<%
}
%>
	
</body>
</html>
