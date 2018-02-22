<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "services.AnaunseoDao" %>
<%@ page import ="services.Anaunseo" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String AnaunseoId = request.getParameter("AnaunseoId");
	AnaunseoDao adao = new AnaunseoDao();
	Anaunseo ana = adao.anaunseoUpdateForm(Integer.parseInt(AnaunseoId));
	
%>

<div>
		<h1 style="text-align: center;">아나운서 수정양식</h1>
	</div>
		<form action = "<%= request.getContextPath() %>/anaunseo/anaunseoUpdateAction.jsp" method = "post">
			<input type="hidden" name="anaunseo_id" value="<%= ana.getAnaunseoId() %>">
			<table border="1">
				<thead>					
					<tr>
						<th>이름</th>
						<td><input type="text" name="anaunseo_name" value="<%= ana.getAnaunseoName() %>" size="20"></td>
					</tr>
					<tr>
						<th>나이</th>
						<td><input type="text" name="anaunseo_age" value="<%= ana.getAnaunseoAge() %>" size="20"></td>
					</tr>
						<tr style = "text-align: left;">
						<td><input type="submit" value="입력하기"></td>
					</tr>
				</thead>
			</table>
		</form>

</body>
</html>