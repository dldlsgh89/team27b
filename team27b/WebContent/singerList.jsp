<!-- ������ -->

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="services.SingerDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="services.Singer" %>
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
	<div style="width: 100%;">
		<div style="width: 90%; float: left;">
			<table style="width: 100%;" border="1">
				<tr>
				<th>���̵�</th><th>�̸�</th><th>����</th>
				</tr>
			
				<%
				SingerDao singerDao = new SingerDao();
				ArrayList<Singer> list = singerDao.selectSingerList();
				
				for(Singer singer : list){
				%>
					<tr>
					<td><%= singer.getSingerId() %></td>
					<td><%= singer.getSingerName() %></td>
					<td><%= singer.getSingerAge() %></td>
					</tr>
				<%
				}
				%>
			</table>
		</div>
		<div style="float:left;">
			<table>
				<tr>
					<td><a href="<%= request.getContextPath() %>/index.jsp">Ȩȭ��</a></td>
				</tr>
				<tr>
					<td><a href="<%= request.getContextPath() %>/index.jsp">�����߰�</a></td>
				</tr>
				<tr>
					<td><a href="<%= request.getContextPath() %>/index.jsp">��������</a></td>
				</tr>
				<tr>
					<td><a href="<%= request.getContextPath() %>/index.jsp">��������</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>

