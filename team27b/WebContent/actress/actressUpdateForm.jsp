<!--27기 B조 배건혜  -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "services.Actress" %>
<%@ page import = "services.ActressDao" %>
<!DOCTYPE html>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>actressUpdateForm</title>
</head>
<body>
<%
int actressId = Integer.parseInt(request.getParameter("ActressId"));
ActressDao actressDao = new ActressDao();
Actress actress = actressDao.updateActressForm(actressId);
%>
	<div>
		<h1 style="text-align: center;">여배우 수정양식</h1>
	</div>
	<form action="<%=request.getContextPath()%>/actress/actressUpdateAction.jsp" method="post">
		<input type="hidden" name= "actress_id" value="<%= actress.getActressId()%>">
		<table border="1">
			<thead>
				<tr>
					<td>이름</td>
					<td><input type="text" name="actress_name" value="<%=actress.getActressName() %>" size="20"></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="actress_age" value="<%=actress.getActressAge() %>" size="20"></td>
				</tr>
				<tr style="text-align: left;">
					<td><input type="submit" value="수정"></td>
				</tr>
			</thead>
		</table>
	</form>
</body>
</html>