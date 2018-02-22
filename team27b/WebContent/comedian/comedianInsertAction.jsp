<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "services.Comedian" %>
<%@ page import = "services.ComedianDao" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euckr");
    String comedianName = request.getParameter("comedian_name");  
	String comedianAge = request.getParameter("comedian_age");  

	Comedian com = new Comedian();
	
	com.setComedianName(comedianName);
	com.setComedianAge(Integer.parseInt(comedianAge));
	
	ComedianDao	Cdo = new ComedianDao();
	Cdo.insertComedian(com);

	response.sendRedirect(request.getContextPath()+"/comedian/comedianList.jsp");
%>

