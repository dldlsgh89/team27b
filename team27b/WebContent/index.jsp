<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

팀명 Team27b

<ul>
	이인호
	<li><a href="<%= request.getContextPath() %>/anaunseo/anaunseoList.jsp">Anaunseo</a></li>
	<li><a href="<%= request.getContextPath() %>/comedion/comedionList.jsp">Comedion</a></li>
	배건혜
	<li><a href="<%= request.getContextPath() %>/actor/actorList.jsp">actor</a></li>
	<li><a href="<%= request.getContextPath() %>/actress/actressList.jsp">actress</a></li>
	나성수
	<li><a href="<%= request.getContextPath() %>/rapper/rapperList.jsp">rapper</a></li>
	<li><a href="<%= request.getContextPath() %>/singer/singerList.jsp">singer</a></li>
</ul>


</body>
</html>