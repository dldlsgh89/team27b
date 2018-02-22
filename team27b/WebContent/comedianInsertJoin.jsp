<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "services.Comedian" %>
<%@ page import = "services.ComedianDao" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euckr");
    String comedianname = request.getParameter("comedian_name");  
	String comedianage = request.getParameter("comedian_age");  

	Comedian com = new Comedian();
	
	com.setComedianname(comedianname);
	com.setComedianage(Integer.parseInt(comedianage));
	
	ComedianDao	Cdo = new ComedianDao();
	Cdo.insertComedian(com);

	response.sendRedirect(request.getContextPath()+"/comedianList.jsp");
%>

