<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "services.ComedianDao" %>
<!DOCTYPE html>

<%
	int ComedianId = Integer.parseInt(request.getParameter("ComedianId"));
	
	ComedianDao adao = new ComedianDao();
	adao.deleteComedianList(ComedianId);
	
	response.sendRedirect(request.getContextPath()+"/comedian/comedianList.jsp");
%>