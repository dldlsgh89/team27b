<!-- 27�� B�� �����  -->
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
<%-- <%
		Actress	actress = new ActressDao();	
		ArrayList<Actress> Array = Cdo.selectComedianList();		
		for(Actress com : ArrayCom){
	%>	
		<tbody>
			<tr>
				<td><%= com.getComedianid() %></td>
				<td><%= com.getComedianname() %></td>
				<td><%= com.getComedianage() %></td>
			</tr>
		</tbody>	
	<%
		}
	%> --%>
			</table>
		</div>
		<div style="float:left;">
			<table>
				<tr>
					<td><a href="<%= request.getContextPath() %>/index.jsp">Ȩȭ��</a></td>
				</tr>
				<tr>
					<td><a href="<%= request.getContextPath() %>/index.jsp">������߰�</a></td>
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