<!-- //27기 B조 이인호 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "services.ComedianDao" %>
<!DOCTYPE html>

<%
	int comedianId = Integer.parseInt(request.getParameter("ComedianId"));
	
	ComedianDao comedianDao = new ComedianDao();
	comedianDao.deleteComedian(comedianId);
	
	response.sendRedirect(request.getContextPath()+"/comedian/comedianList.jsp");
%>