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
	<div>
		<h1 style="text-align: center;">���� ���� ���</h1>
	</div>
	<div>
		<span style="padding: 0 1% 0 1%;">
			<a href="<%= request.getContextPath() %>/index.jsp" style="text-decoration: none;">Ȩȭ��</a>
		</span>
		<span style="padding: 0 1% 0 1%;">
			<a href="<%= request.getContextPath() %>/rapperInsertForm.jsp" style="text-decoration: none;">�����߰�</a>
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
</body>
</html>