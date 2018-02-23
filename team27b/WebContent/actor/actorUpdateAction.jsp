<!-- 27±âBÁ¶ ¹è°ÇÇý -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.ActorDao"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("EUC-KR");
	int actorId = Integer.parseInt(request.getParameter("actorId"));
	String actorName = request.getParameter("actorName");
	int actorAge = Integer.parseInt(request.getParameter("actorAge"));

	ActorDao actorDao = new ActorDao();
	actorDao.updateActorAction(actorId, actorName, actorAge);

	response.sendRedirect(request.getContextPath() + "/actor/actorList.jsp");
%>
