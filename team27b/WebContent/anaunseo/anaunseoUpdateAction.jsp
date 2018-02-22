<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "services.AnaunseoDao"%>
<!DOCTYPE html>

<%
	request.setCharacterEncoding("EUC-KR");
	int anaunseoid = Integer.parseInt(request.getParameter("anaunseo_id"));
	String anaunseoname = request.getParameter("anaunseo_name");
	int anaunseoage = Integer.parseInt(request.getParameter("anaunseo_age"));
	
	AnaunseoDao adao = new AnaunseoDao();
	adao.anaunseoUpdateAction(anaunseoid, anaunseoname, anaunseoage);
						
	response.sendRedirect(request.getContextPath()+"/anaunseo/anaunseoList.jsp");
%>