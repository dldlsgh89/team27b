<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="services.Member" %>
<%@ page import="services.MemberDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
String memberId = request.getParameter("memberId");
String memberPw = request.getParameter("memberPw");

Member member = new Member();
member.setMemberId(memberId);
member.setMemberPw(memberPw);

MemberDao memberDao = new MemberDao();
Member member2 = memberDao.memberLogin(member);

if(member2 != null){
	session.setAttribute("S_ID", member2.getMemberId());
	response.sendRedirect(request.getContextPath()+"/index.jsp");
}else{
%>
<script type="text/javascript">
	alert('로그인 실패');
	location.href="<%=request.getContextPath()%>/index.jsp";
</script>
<%
}
%>
</body>
</html>