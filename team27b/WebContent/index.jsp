<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

팀명 Team27b

	<ul>
		<img src="https://search.pstatic.net/common?type=a&size=120x150&quality=95&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F201703%2F20170310160206249.jpg" width="" height=""/>
		<br>이인호
		<li><a href="<%= request.getContextPath() %>/anaunseoList.jsp">Anaunseo</a></li>
		<li><a href="<%= request.getContextPath() %>/comedionList.jsp">Comedion</a></li>
		
		<img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fimgnews.naver.com%2Fimage%2F020%2F2011%2F02%2F21%2F35006390.1.jpg&type=b400" width="150px" height="200px"/>
		<br>배건혜
		<li><a href="<%= request.getContextPath() %>/actorList.jsp">actor</a></li>
		<li><a href="<%= request.getContextPath() %>/actressList.jsp">actress</a></li>
		        
		<img src="#" width="" height=""/>
		<br>나성수
		<li><a href="<%= request.getContextPath() %>/rapperList.jsp">rapper</a></li>
		<li><a href="<%= request.getContextPath() %>/singerList.jsp">singer</a></li>
	</ul>


</body>
</html>