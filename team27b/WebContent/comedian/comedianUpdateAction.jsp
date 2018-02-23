<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "services.ComedianDao" %>
<!DOCTYPE html>

<%
	request.setCharacterEncoding("EUC-KR");
	int comedianId = Integer.parseInt(request.getParameter("comedian_id"));
	String comedianName = request.getParameter("comedian_name");
	int comedianAge = Integer.parseInt(request.getParameter("comedian_age"));
	
	ComedianDao comedianDao = new ComedianDao();
	comedianDao.updateComedianAction(comedianId, comedianName, comedianAge);
	
	response.sendRedirect(request.getContextPath()+"/comedian/comedianList.jsp");
%>
