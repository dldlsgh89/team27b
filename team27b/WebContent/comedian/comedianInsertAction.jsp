<!-- //27기 B조 이인호 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "services.Comedian" %>
<%@ page import = "services.ComedianDao" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euckr");
    String comedianName = request.getParameter("comedian_name");  
	int comedianAge = Integer.parseInt(request.getParameter("comedian_age"));  
	
	ComedianDao	comedianDao = new ComedianDao();
	comedianDao.insertComedian(comedianName, comedianAge);

	response.sendRedirect(request.getContextPath()+"/comedian/comedianList.jsp");
%>

