<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="services.ActressDao"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("EUC-KR");
	int actressid = Integer.parseInt(request.getParameter("actress_id"));
	String actressname = request.getParameter("actress_name");
	int actressage = Integer.parseInt(request.getParameter("actress_age"));

	ActressDao actressDao = new ActressDao();
	actressDao.updateActionActress(actressid, actressname, actressage);

	response.sendRedirect(request.getContextPath() + "/actress/actressList.jsp");
%>
