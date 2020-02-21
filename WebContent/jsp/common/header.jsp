<%@page import="vo.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<!-- Favicon  -->
<link rel="icon" href="/Vilsam_yj/img/core-img/favicon.ico" />

<!-- Core Style CSS-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/core-style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/loginst.css" />
<script src="${pageContext.request.contextPath }/js/newjs.js"></script>
<script type="text/javascript">
	function goPage() {
		location.href = "/jsp/loginForm.jsp";
	}
	function goJoin() {
		location.href = "/jsp/joinForm.jsp";
	}
	function goLogout() {
		location.href = "/jsp/logoutForm.jsp";
	}
	function gonotice() {
		location.href = "/jsp/notice/qna_notice_list.jsp";
	}
	function gorent() {
		location.href = "/jsp/notice/qna_space_list.jsp";
	}
	function goAdmin() {
		location.href = "/memberListAction.me";
	}
	function goMyp() {
		location.href = "/memberMypageAction.me?MEMBER_ID=${MEMBER_ID}";
	}
</script>
<title>Document</title>
</head>
<body>
	<div class="container">
		<header>
		<div
			style="text-align: center; margin-top: 25px; font-weight: bold; text-decoration: none;">
			<ul class="usernav">
			<c:choose>
<c:when test="${MEMBER_ID eq null }" >
				<li><a onclick="javascript:goPage()">Login&nbsp;&nbsp;&nbsp;|</a></li>
				<li><a onclick="javascript:goJoin()">무료회원가입&nbsp;&nbsp;&nbsp;|</a></li>
</c:when>
<c:otherwise>
				<li>${MEMBER_ID }님</li>
				<c:choose>
				<c:when test="${MEMBER_TYPE eq 'admin' }">
				<li><a onclick="javascript:goAdmin()">관리자 페이지</a></li>
				</c:when>
				<c:otherwise>
				<li><a onclick="javascript:goMyp()">마이페이지</a></li></c:otherwise>
				</c:choose>
				<li><a onclick="javascript:goLogout()">로그아웃</a></li>
</c:otherwise>
</c:choose>

			</ul>
		</div>
		<div class="logo">
			<a href="/index.jsp"><img
				src="/img/core-img/logo.png" /></a>
		</div>

		</header>

		<div class="xs-menu-cont"></div>
		<nav class="menu">
		<ul>
			<li class="active"><a href="#">Home</a></li>
			<!-- <li class=""><a href="#">Products</a></li> -->
			<li><a href="/jsp/notice/NoticeList.jsp">공지사항</a></li>
			<li><a href="/jsp/space/SpaceList.jsp">공간대여</a></li> 
		</ul>
		</nav>
	</div>


</body>
</html>