<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.ActorDao"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("EUC-KR");
	int actorid = Integer.parseInt(request.getParameter("actor_id"));
	String actorname = request.getParameter("actor_name");
	int actorage = Integer.parseInt(request.getParameter("actor_age"));

	ActorDao actorDao = new ActorDao();
	actorDao.updateActionActor(actorid, actorname, actorage);

	response.sendRedirect(request.getContextPath() + "/actor/actorList.jsp");
%>
