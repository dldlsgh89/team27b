<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>





<%	
	
    
	



%><%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>


<%@  page import= "services.Anaunseo" %>
<%@ page import = "services.AnaunseoDao" %>


<table width="100%" border="1">
<tr>
	<td>���̵�</td><td>�̸�</td><td>����</td>
</tr>

<%
	AnaunseoDao AnaDao = new AnaunseoDao();

	AnaDao.SelectAnaunseoList(){

	Anaunseo Ana = new Anaunseo();
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