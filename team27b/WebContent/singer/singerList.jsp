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
	<div>
		<span style="padding: 0 1% 0 1%;">
			<a href="<%= request.getContextPath() %>/index.jsp" style="text-decoration: none;">Ȩȭ��</a>
		</span>
		<span style="padding: 0 1% 0 1%;">
			<a href="<%= request.getContextPath() %>/singerInsertForm.jsp" style="text-decoration: none;">�����߰�</a>
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
						<td><a href="<%=request.getContextPath() %>/singerUpdateForm.jsp?SingerId=<%=singer.getSingerId()%>" style="text-decoration: none;">����</a></td>
						<td><a href="<%=request.getContextPath() %>/singerDeleteAction.jsp?SingerId=<%=singer.getSingerId()%>" style="text-decoration: none;">����</a></td>
					</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>
