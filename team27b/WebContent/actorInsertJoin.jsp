<!--27±â BÁ¶ ¹è°ÇÇý  -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "services.Actor" %>
<%@ page import = "services.ActorDao" %>
<!DOCTYPE html>
<%
request.setCharacterEncoding("euckr");
String actorName = request.getParameter("actor_name");
String actorAge = request.getParameter("actor_age");

Actor actor = new Actor();
actor.setActorName(actorName);
actor.setActorAge(Integer.parseInt(actorAge));

ActorDao actordao = new ActorDao();
actordao.insertActor(actor);

response.sendRedirect(request.getContextPath()+"/actorList.jsp");
%>

