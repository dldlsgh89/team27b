<!-- //27�� B�� ����ȣ -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "services.ComedianDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "services.Comedian" %>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1 style="text-align: center;">�ڹ̵�� ���� ���</h1>
	</div>
	<div style="width: 100%;">
		<div style="width: 85%; float: left;">
			<table style="width: 100%;" border="1">
				<tr>
				<th>���̵�</th><th>�̸�</th><th>����</th>
				</tr>
	<%
		ComedianDao	Cdo = new ComedianDao();	
		ArrayList<Comedian> ArrayCom = Cdo.SelectComedianList();		
		for(Comedian com : ArrayCom){
	%>	
			<tr>
				<td><%= com.getComedianid() %></td>
				<td><%= com.getComedianname() %></td>
				<td><%= com.getComedianage() %></td>
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
					<td><a href="<%= request.getContextPath() %>/index.jsp">�ڹ̵���߰�</a></td>
				</tr>
				<tr>
					<td><a href="<%= request.getContextPath() %>/index.jsp">�ڹ̵�����</a></td>
				</tr>
				<tr>
					<td><a href="<%= request.getContextPath() %>/index.jsp">�ڹ̵�����</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>