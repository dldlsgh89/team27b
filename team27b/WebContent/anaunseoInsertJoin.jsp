<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.Anaunseo"  %>
<%@ page import="services.AnaunseoDao" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euckr");
    String anaunseoname = request.getParameter("anaunseo_name");  
	String anaunseoage = request.getParameter("anaunseo_age");  
	
	Anaunseo ana = new Anaunseo();
	
	ana.setAnaunseoname(anaunseoname);
	ana.setAnaunseoage(Integer.parseInt(anaunseoage));
	
	AnaunseoDao	Ado = new AnaunseoDao();
	Ado.insertAnaunseo(ana);

	response.sendRedirect(request.getContextPath()+"/anaunseoList.jsp");	
%>
