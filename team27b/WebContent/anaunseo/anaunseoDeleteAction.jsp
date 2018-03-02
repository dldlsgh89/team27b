<!-- //27기 B조 이인호 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "services.AnaunseoDao" %>
<!DOCTYPE>

<%
	int anaunseoId = Integer.parseInt(request.getParameter("AnaunseoId"));
	
	AnaunseoDao anaunseoDao = new AnaunseoDao();
	anaunseoDao.deleteAnaunseo(anaunseoId);
	
	response.sendRedirect(request.getContextPath()+"/anaunseo/anaunseoList.jsp");
%>
