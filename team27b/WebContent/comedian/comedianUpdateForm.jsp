<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.ComedianDao" %>
<%@ page import ="services.Comedian" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	int comedianId = Integer.parseInt(request.getParameter("ComedianId"));
	ComedianDao comedianDao = new ComedianDao();
	Comedian comedian = comedianDao.updateComedianForm(comedianId);
	
%>

<div>
		<h1 style="text-align: center;">�ڹ̵�� �������</h1>
	</div>
		<form action = "<%= request.getContextPath() %>/comedian/comedianUpdateAction.jsp" method = "post">
			<input type="hidden" name="comedian_id" value="<%= comedian.getComedianId() %>">
			<table border="1">
				<thead>					
					<tr>
						<th>�̸�</th>
						<td><input type="text" name="comedian_name" value="<%= comedian.getComedianName() %>" size="20"></td>
					</tr>
					<tr>
						<th>����</th>
						<td><input type="text" name="comedian_age" value="<%= comedian.getComedianAge() %>" size="20"></td>
					</tr>
						<tr style = "text-align: left;">
						<td><input type="submit" value="����"></td>
					</tr>
				</thead>
			</table>
		</form>

</body>
</html>