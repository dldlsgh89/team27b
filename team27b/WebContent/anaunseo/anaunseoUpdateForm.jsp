<!-- //27기 B조 이인호 -->

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
	int anaunseoId = Integer.parseInt(request.getParameter("AnaunseoId"));
	AnaunseoDao anaunseoDao = new AnaunseoDao();
	Anaunseo anaunseo = anaunseoDao.updateAnaunseoForm(anaunseoId);
	
%>

<div>
		<h1 style="text-align: center;">아나운서 수정양식</h1>
	</div>
		<form action = "<%= request.getContextPath() %>/anaunseo/anaunseoUpdateAction.jsp" method = "post">
			<input type="hidden" name="anaunseo_id" value="<%= anaunseo.getAnaunseoId() %>">
			<table border="1">
				<thead>					
					<tr>
						<th>이름</th>
						<td><input type="text" name="anaunseo_name" value="<%= anaunseo.getAnaunseoName() %>" size="20"></td>
					</tr>
					<tr>
						<th>나이</th>
						<td><input type="text" name="anaunseo_age" value="<%= anaunseo.getAnaunseoAge() %>" size="20"></td>
					</tr>
						<tr style = "text-align: left;">
						<td><input type="submit" value="수정"></td>
					</tr>
				</thead>
			</table>
		</form>

</body>
</html>