<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "services.AnaunseoDao" %>
<!DOCTYPE>

<%
	int AnaunseoId = Integer.parseInt(request.getParameter("AnaunseoId"));
	
	AnaunseoDao adao = new AnaunseoDao();
	adao.deleteAnaunseoList(AnaunseoId);
	
	response.sendRedirect(request.getContextPath()+"/anaunseoList.jsp");
%>
