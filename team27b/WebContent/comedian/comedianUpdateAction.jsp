<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "services.ComedianDao" %>
<!DOCTYPE html>

<%
	request.setCharacterEncoding("EUC-KR");
	int comedianid = Integer.parseInt(request.getParameter("comedian_id"));
	String comedianname = request.getParameter("comedian_name");
	int comedianage = Integer.parseInt(request.getParameter("comedian_age"));
	
	ComedianDao cdao = new ComedianDao();
	cdao.comedianUpdateAction(comedianid, comedianname, comedianage);
	
	response.sendRedirect(request.getContextPath()+"/comedian/comedianList.jsp");
%>
