<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String id=null;

	if (session.getAttribute("MEMBER_ID")!=null){
		id=(String)session.getAttribute("MEMBER_ID");
	}else{
		out.println("<script>");
		out.println("location.href='loginForm.jsp'");
		out.println("</script>");
	}
%>
<html>
<head>
<title>회원관리 시스템 메인 페이지</title>
</head>
<body>
<h3><%=id %> 로 로그인하셨습니다.</h3>
<a href="logout.jsp">로그아웃</a>
<a href="member_mod.jsp">회원정보 수정</a>
<%if(id.equals("admin")){%>
<a href="member_list.jsp">관리자모드 접속(회원 목록 보기)</a>
<%}%>
</body>
</html>
