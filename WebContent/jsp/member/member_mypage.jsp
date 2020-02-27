<%@page import="vo.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
	String id = (String) session.getAttribute("MEMBER_ID");

%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vilsam | 마이페이지</title>

<!-- Favicon  -->
<link rel="icon"
	href="${pageContext.request.contextPath }/img/core-img/favicon.ico">
<!-- Core Style CSS-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/core-style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/loginst.css" />
<script src="http://code.jquery.com/jquery-latest.js"></script>
<!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
<script src="${pageContext.request.contextPath }/js/newjs.js"></script>
<!-- Popper js -->
<script src="${pageContext.request.contextPath }/js/popper.min.js"></script>
<!-- Bootstrap js -->
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<!-- Plugins js -->
<script src="${pageContext.request.contextPath }/js/plugins.js"></script>
<!-- Active js -->
<script src="${pageContext.request.contextPath }/js/active.js"></script>

<style>
#memberListArea {
	width: 400px;
	margin: auto;
}

table {
	width: 380px;
	margin: auto;
	text-align: center;
	padding: 10px;
}

table tr, td {
	border: 1px solid #9c9c9c;
	padding: 10px;
}

h1 {
	font-size: 3em;
	margin-bottom: 3%;
}
</style>
</head>
<body>
	<jsp:include page="/jsp/common/header.jsp" flush="true"></jsp:include>
	<div id="wrap" class="wrap">
		<div class="wrap-inner">
			<!--Signup Section-->
			<div class="section" id="section2">
				<div class="form form--signup">
					<form name="loginform" id="Delform"
						action="/Vilsam_yj/memberDeleteAction.me" method="post"
						class="form-wrap">
						<h1 class="alpha">마이페이지</h1>
						<p>${member.MEMBER_NAME}님의 마이페이지입니다.</p>
						<br>
						<br>
						<table id="memberListArea" class="form-wrap">
							<h1 class="alpha">회원정보</h1>

							<tr>
								<td>아이디 :</td>
								<td>${MEMBER_ID }</td>
							</tr>
							<tr>
							<%-- 	<td>비밀번호 :</td>
								<td>${member.MEMBER_PW }</td> --%>
							</tr>
							<tr>
								<td>이름 :</td>
								<td>${member.MEMBER_NAME}</td>
							</tr>
					
							<tr>
								<td>성별 :</td>
								<td>${member.MEMBER_GENDER}</td>
							</tr>
							<tr>
								<td>이메일 주소 :</td>
								<td>${member.MEMBER_EMAIL}</td>
							</tr>
							<tr>
								<td>주소 :</td>
								<td>${member.MEMBER_ADDR1}</td>
							</tr>
											<tr>
								<td>폰번호 :</td>
								<td>${member.MEMBER_PHONE1}${member.MEMBER_PHONE2}</td>
							</tr>
									<tr>
								<td>생년월일 :</td>
								<td>${member.MEMBER_BIRTH}</td>
							</tr>
							<br>
							<br>
							<br>
						</table>
						<br>
						<br> <a
							href="/Vilsam_yj/memberDeleteAction.me?MEMBER_ID=${MEMBER_ID}"
							class="btst">탈퇴하기</a>
							<%-- <a href="/Vilsam_yj/memberModiForm.me?MEMBER_ID=${MEMBER_ID}" class="btst">수정하기</a> --%>
							<a href="/Vilsam_yj/memberModiForm.me?MEMBER_ID=${member.MEMBER_ID}" class="btst">수정하기</a> <br>
						<br>
						<br>


						<h1 class="alpha">주문내역</h1>
						<br> <br> <a
							href="/Vilsam_yj/sellList.se?MEMBER_ID=${MEMBER_ID}" class="btst">내
							주문내역 보기</a> <br>
					</form>

				</div>

			</div>
		</div>
	</div>
	<jsp:include page="/jsp/common/footer.jsp" flush="true"></jsp:include>
</body>
</html>