<!-- //27기 B조 이인호 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.Anaunseo"  %>
<%@ page import="services.AnaunseoDao" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euckr");
    String anaunseoName = request.getParameter("anaunseo_name");  
	int anaunseoAge = Integer.parseInt(request.getParameter("anaunseo_age"));
						  
		
	AnaunseoDao	anaunseoDao = new AnaunseoDao();
	anaunseoDao.insertAnaunseo(anaunseoName, anaunseoAge);

	response.sendRedirect(request.getContextPath()+"/anaunseo/anaunseoList.jsp");	
%>
