<!-- 27�� B�� �����  -->
<%@ page import = "services.Actress" %>
<%@ page import = "services.ActressDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<div>
			<h1 style="text-align: center;">����� ���� ���</h1>
	</div>
		<div style="width: 100%;">
			<div style="width: 85%; float: left;">
				<table style="width: 100%;" border="1">
					<thead>
						<tr>
						<th>���̵�</th><th>�̸�</th><th>����</th>
						</tr>
					</thead>
 <%
 		ActressDao actressDao = new ActressDao();
 		ArrayList<Actress> arrayActress = actressDao.selectActressList();
 		for(int i = 0; i<arrayActress.size(); i++){
 			Actress actress = arrayActress.get(i);
%>	
		<tbody>
			<tr>
				<td><%= actress.getActressId() %></td>
				<td><%= actress.getActressName()  %></td>
				<td><%= actress.getActressAge() %></td>
			</tr>
		</tbody>	
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
					<td><a href="<%= request.getContextPath() %>/actressInsertForm.jsp">������߰�</a></td>
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