<!-- //27기 B조 이인호 -->

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
	anaunseoList.jsp<br>

	<table width="100%" border="1">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>나이</td>
		</tr>
	
	<%
		AnaunseoDao Ado = new AnaunseoDao();
		ArrayList<Anaunseo> ArrayAna = Ado.SelectAnaunseoList();		
		for(int i = 0; i<ArrayAna.size(); i++){
			Anaunseo Ana = ArrayAna.get(i);			
	%>
				
			<tr>
				<td><%= Ana.getAnaunseoid()%></td>
				<td><%= Ana.getAnaunseoname()%></td>
				<td><%= Ana.getAnaunseoage()%></td>				
			</tr>				
	<%
			}
	%>
	</table>	
<a href="<%= request.getContextPath() %>/index.jsp">홈화면</a>
</body>
</html>	