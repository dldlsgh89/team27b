
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="services.ActorDao" %>
<%@ page import="services.Actor" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<table width="100%" border="1">
	<tr>
		<td>���̵�</td>
		<td>�̸�</td>
		<td>����</td>
	</tr>
	<%
	ActorDao actorDao = new ActorDao();
	ArrayList<Actor> List = actorDao.selectActorList();
	for (Actor actor : List){	
	%>	
		<tr>
			<td><%= actor.getActorId()%></td>
			<td><%= actor.getActorName()%></td>
			<td><%= actor.getActorAge()%></td>		
		</tr>
<%
	}
%>
</table>		