<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "services.AnaunseoDao"%>
<!DOCTYPE html>

<%
	request.setCharacterEncoding("EUC-KR");
	int anaunseoId = Integer.parseInt(request.getParameter("anaunseo_id"));
	String anaunseoName = request.getParameter("anaunseo_name");
	int anaunseoAge = Integer.parseInt(request.getParameter("anaunseo_age"));
	
	AnaunseoDao anaunseoDao = new AnaunseoDao();
	anaunseoDao.updateAnaunseoAction(anaunseoId, anaunseoName, anaunseoAge);
						
	response.sendRedirect(request.getContextPath()+"/anaunseo/anaunseoList.jsp");
%>