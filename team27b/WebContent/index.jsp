<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

���� Team27b

	<ul>
		<img src="<%= request.getContextPath() %>/image/Lee.jpg" width="" height=""/>
		<br>����ȣ			<!-- ������Ʈ ���̸�  ���-->
		<li><a href="<%= request.getContextPath() %>/anaunseoList.jsp">Anaunseo</a></li>
		<li><a href="<%= request.getContextPath() %>/comedianList.jsp">Comedian</a></li>
		
		<img src="<%= request.getContextPath() %>/image/bae.jpg" width="150px" height="200px"/>
		<br>�����
		<li><a href="<%= request.getContextPath() %>/actorList.jsp">actor</a></li>
		<li><a href="<%= request.getContextPath() %>/actressList.jsp">actress</a></li>
		        
		<img src="<%= request.getContextPath() %>/image/na.jpg" width="" height=""/>
		<br>������
		<li><a href="<%= request.getContextPath() %>/rapperList.jsp">rapper</a></li>
		<li><a href="<%= request.getContextPath() %>/singerList.jsp">singer</a></li>
	</ul>


</body>
</html>