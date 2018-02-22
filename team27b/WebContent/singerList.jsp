<!-- 나성수 -->

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="services.SingerDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="services.Singer" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center;">가수 정보 목록</h1>
	<hr>
	<div>
		<div style="width: 90%; float: left;">
			<table style="width: 100%;" border="1">
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>나이</th>
						<th>수정</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<%
					// SingerDao 객체를 생성하고 singerDao 참조변수에 주소값을 담는다
					SingerDao singerDao = new SingerDao();
					// selectSinger메서드를 호출하고 리턴값인 RsultSet객체주소값을 list 참조변수에 담는다
					ArrayList<Singer> list = singerDao.selectSingerList();
					// list에 담긴 주소를 찾아가 singer객체들을 가져오고 객체들의 양만큼 반복한다
					for(Singer singer : list){
					%>
						<tr>
							<td><%= singer.getSingerId() %></td>
							<td><%= singer.getSingerName() %></td>
							<td><%= singer.getSingerAge() %></td>
							<td><a href="<%=request.getContextPath() %>/singerUpdateForm.jsp?SingerId=<%=singer.getSingerId()%>" style="text-decoration: none;">수정</a></td>
							<td><a href="<%=request.getContextPath() %>/singerDeleteAction.jsp?SingerId=<%=singer.getSingerId()%>" style="text-decoration: none;">삭제</a></td>
						</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
		<div style="width: 10%; float: right;">
			<div style="padding: 0 33% 0 33%;">
				<a href="<%= request.getContextPath() %>/index.jsp" style="text-decoration: none;">홈화면</a>
			</div>
			<div style="padding: 0 28% 0 28%;">
				<a href="<%= request.getContextPath() %>/singerInsertForm.jsp" style="text-decoration: none;">가수추가</a>
			</div>
		</div>
	</div>
</body>
</html>

