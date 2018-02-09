<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<%@  page import= "services.Anaunseo" %>
<%@ page import = "services.AnaunseoDao" %>
<%@ page import = "java.util.ArrayList" %>



<table width="100%" border="1">
<tr>
	<td>아이디</td><td>이름</td><td>나이</td>
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