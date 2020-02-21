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
		location.href = "/Vilsam_yj/jsp/loginForm.jsp";
	}
	function goJoin() {
		location.href = "/Vilsam_yj/jsp/joinForm.jsp";
	}
	function goLogout() {
		location.href = "/Vilsam_yj/jsp/logoutForm.jsp";
	}
	function gonotice() {
		location.href = "/Vilsam_yj/jsp/notice/qna_notice_list.jsp";
	}
	function gorent() {
		location.href = "/Vilsam_yj/jsp/notice/qna_space_list.jsp";
	}
	function goAdmin() {
		location.href = "/Vilsam_yj/memberListAction.me";
	}
	function goMyp() {
		location.href = "/Vilsam_yj/memberMypageAction.me?MEMBER_ID=${MEMBER_ID}";
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
				<c:when test="${MEMBER_TYPE eq 'admin'}">
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
			<a href="/Vilsam_yj/productList.pro">
				<img src="/Vilsam_yj/img/core-img/logo.png" />
			</a>
		</div>

		</header>

		<div class="xs-menu-cont"></div>
		<nav class="menu">
		<ul>
			<li class="active"><a href="#">Home</a></li>
			<li><a href="/Vilsam_yj/jsp/notice/NoticeList.jsp">공지사항</a></li>
			<li><a href="/Vilsam_yj/jsp/room/RoomList.jsp">공간대여</a></li> 
		</ul>
		</nav>
	</div>

	<!-- 자바스크립트 라이브러리 -->
	<script src="https://kit.fontawesome.com/1773caa337.js" crossorigin="anonymous"></script>
</body>
</html>