<!--27±â BÁ¶ ¹è°ÇÇý  -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "services.Actress" %>
<%@ page import = "services.ActressDao" %>
<!DOCTYPE html>
<% 
request.setCharacterEncoding("euckr");
String actressName = request.getParameter("actress_name");
String actressAge = request.getParameter("actress_age");


ActressDao actressdao = new ActressDao();
actressdao.insertActress(actressName, Integer.parseInt(actressAge));

response.sendRedirect(request.getContextPath()+"/actress/actressList.jsp");
%>

