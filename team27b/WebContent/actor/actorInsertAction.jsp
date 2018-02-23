<!--27±â BÁ¶ ¹è°ÇÇý  -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.Actor"%>
<%@ page import="services.ActorDao"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euckr");
	String actorName = request.getParameter("actor_name");
	int actorAge = Integer.parseInt( request.getParameter("actor_age"));

	ActorDao actordao = new ActorDao();
	actordao.insertActor(actorName, actorAge);

	response.sendRedirect(request.getContextPath() + "/actor/actorList.jsp");
%>

