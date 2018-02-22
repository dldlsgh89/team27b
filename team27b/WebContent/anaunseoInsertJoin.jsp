<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.Anaunseo"  %>
<%@ page import="services.AnaunseoDao" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euckr");
    String anaunseoName = request.getParameter("anaunseo_name");  
	String anaunseoAge = request.getParameter("anaunseo_age");  
	
	Anaunseo ana = new Anaunseo();
	
	ana.setAnaunseoName(anaunseoName);
	ana.setAnaunseoAge(Integer.parseInt(anaunseoAge));
	
	AnaunseoDao	Ado = new AnaunseoDao();
	Ado.insertAnaunseo(ana);

	response.sendRedirect(request.getContextPath()+"/anaunseoList.jsp");	
%>
