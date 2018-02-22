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
	<h1 style="text-align: center;">���� ���� ���</h1>
	<hr>
	<div style="width: 100%;">
		<div style="width: 90%; float: left;">
			<table style="width: 100%;" border="1">
				<thead>
					<tr>
					<th>���̵�</th><th>�̸�</th><th>����</th>
					</tr>
				</thead>
				<tbody>
					<%
					// SingerDao ��ü�� �����ϰ� singerDao ���������� �ּҰ��� ��´�
					SingerDao singerDao = new SingerDao();
					// selectSinger�޼��带 ȣ���ϰ� ���ϰ��� RsultSet��ü�ּҰ��� list ���������� ��´�
					ArrayList<Singer> list = singerDao.selectSingerList();
					// list�� ��� �ּҸ� ã�ư� singer��ü���� �������� ��ü���� �縸ŭ �ݺ��Ѵ�
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
				</tbody>
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

