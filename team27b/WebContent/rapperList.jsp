<!-- ������ -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.RapperDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="services.Rapper" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center;">���� ���� ���</h1>
	<hr>
	<div>
		<div style="width: 90%; float: left;">
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
				<tbody>
					<%
					RapperDao rapperDao = new RapperDao();
					ArrayList<Rapper> list = rapperDao.selectRapperList();
					
					for(Rapper rapper : list){
					%>
						<tr>
							<td><%= rapper.getRapperId() %></td>
							<td><%= rapper.getRapperName() %></td>
							<td><%= rapper.getRapperAge() %></td>
							<td><a href="<%=request.getContextPath()%>/rapperUpdateForm.jsp?RapperId=<%=rapper.getRapperId()%>" style="text-decoration: none;">����</a></td>
							<td><a href="<%=request.getContextPath()%>/rapperDeleteAction.jsp?RapperId=<%=rapper.getRapperId()%>" style="text-decoration: none;">����</a></td>
						</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
		<div style="width: 10%; float: right;">
			<div style="padding: 0 33% 0 33%;">
				<a href="<%= request.getContextPath() %>/index.jsp" style="text-decoration: none;">Ȩȭ��</a>
			</div>
			<div style="padding: 0 28% 0 28%;">
				<a href="<%= request.getContextPath() %>/rapperInsertForm.jsp" style="text-decoration: none;">�����߰�</a>
			</div>
		</div>
	</div>
</body>
</html>
