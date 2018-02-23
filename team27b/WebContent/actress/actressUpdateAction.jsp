<!--27±â BÁ¶ ¹è°ÇÇý  -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="services.ActressDao"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("EUC-KR");
	int actressId = Integer.parseInt(request.getParameter("actress_id"));
	String actressName = request.getParameter("actress_name");
	int actressAge = Integer.parseInt(request.getParameter("actress_age"));

	ActressDao actressDao = new ActressDao();
	actressDao.updateActressAction(actressId, actressName, actressAge);

	response.sendRedirect(request.getContextPath() + "/actress/actressList.jsp");
%>
