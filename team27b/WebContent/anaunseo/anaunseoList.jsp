<!-- //27�� B�� ����ȣ -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import= "services.Anaunseo" %>
<%@ page import = "services.AnaunseoDao" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1 style="text-align: center;">�Ƴ�� ���� ���</h1>
	</div>
	<div>
		<span style="padding: 0 1% 0 1%;">
			<a href="<%= request.getContextPath() %>/index.jsp" style="text-decoration: none;">Ȩȭ��</a>
		</span>
		<span style="padding: 0 1% 0 1%;">
			<a href="<%= request.getContextPath() %>/anaunseo/anaunseoInsertForm.jsp" style="text-decoration: none;">�Ƴ���߰�</a>
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
		<!-- ���̺� ���κп��� �� Į����ġ�� ������ ���� ����ش� -->
	
	<%
		AnaunseoDao Ado = new AnaunseoDao();
		ArrayList<Anaunseo> ArrayAna = Ado.selectAnaunseoList();		
		for(int i = 0; i<ArrayAna.size(); i++){
			Anaunseo Ana = ArrayAna.get(i);			
			//
	%>
				<tbody>	
					<tr>
						<td><%= Ana.getAnaunseoId()%></td>
						<td><%= Ana.getAnaunseoName()%></td>
						<td><%= Ana.getAnaunseoAge()%></td>	
						<td><a href="<%= request.getContextPath() %>/anaunseo/anaunseoUpdateForm.jsp?AnaunseoId=<%=Ana.getAnaunseoId()%>">�Ƴ������</a></td>
						<td><a href="<%= request.getContextPath() %>/anaunseo/anaunseoDeleteAction.jsp?AnaunseoId=<%=Ana.getAnaunseoId()%>">�Ƴ������</a></td>		
					</tr>
				</tbody>									
	<%
			}
	%>
		</table>	
		</div>
</body>
</html>
