
<%@ page language="java" contentType="text/html; charset=EUC-KR"pageEncoding="EUC-KR"%>
<%@ page import="services.ActorDao" %>
<%@ page import="services.Actor" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>

<%
ActorDao actorDao = new ActorDao();
ArrayList<Actor> actorList = actorDao.selectActorList();
for (Actor actor : actorList){
	
%>


<%
}
%>