<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%-- <%
	String id = (String) session.getAttribute("MEMBER_ID");
%> --%>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자모드(회원 정보 보기)</title>
<style>
#infoformArea {
	margin: auto;
	width: 400px;
}

table {
	width: 380px;
	margin: auto;
	text-align: center;
}
</style>
<script>
	$(function() {
		$('#btnDel').click(function() {
			$('#Delform').submit();
		});
	});
	function goMemDel() {
		location.href = "/memberDeleteAction.me";
	}
	function goBack() {
		location.href = "/memberListAction.me";
	}
</script>
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
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script>
	$(document).ready(function() {
		
		$("#btnModify").click(function() {
			if ($("#MEMBER_ID").val() == "") {
				alert("아이디를 입력하세요!");
				$("#MEMBER_ID").focus();
				return false;
			}
			if ($("#MEMBER_NAME").val() == "") {
				alert("이름을 입력하세요!");
				$("#MEMBER_NAME").focus();
				return false;
			}
			if ($("#MEMBER_PW").val() == "") {
				alert("비밀번호를 입력하세요!");
				$("#MEMBER_PW").focus();
			}
			 if ($("#MEMBER_EMAIL").val() == "") {
				alert("메일을 입력하세요!");
				$("#MEMBER_EMAIL").focus();
				return false;
			}
			if ($("#MEMBER_ZIPCODE").val() == "") {
				alert("주소를 입력하세요!");
				$("#MEMBER_ZIPCODE").focus();
				return false;
			}
			if ($("#MEMBER_ADDR1").val() == "") {
				alert("주소를 입력하세요!");
				$("#MEMBER_ADDR1").focus();
				return false;
			}
			if ($("#MEMBER_ADDR2").val() == "") {
				alert("주소를 입력하세요!");
				$("#MEMBER_ADDR2").focus();
				return false;
			}
			if ($("#MEMBER_BIRTHYY").val() == "") {
				alert("생년월일을 입력하세요!");
				$("#MEMBER_BIRTHYY").focus();
				return false;
			}
			if ($("#MEMBER_BIRTHMM").val() == "") {
				alert("생년월일을 입력하세요!");
				$("#MEMBER_BIRTHMM").focus();
				return false;
			}
			if ($("#MEMBER_BIRTHDD").val() == "") {
				alert("생년월일을 입력하세요!");
				$("#MEMBER_BIRTHDD").focus();
				
				return false;
			} 
			$('#modifyForm').submit();
		});
	});

</script>
</head>
<body>
	<jsp:include page="/jsp/common/header.jsp" flush="true"></jsp:include>
	<div id="wrap" class="wrap">
		<div class="wrap-inner">
			<!--Signup Section-->
			<div class="section" id="section2">
				<div class="form form--signup">

					<section id="infoformArea">
						<form name="modifyForm" id="modifyForm" action="/memberModifyAction.me" method="post" class="form-wrap">
							<h2>회원정보</h2>
							<table>
								<tr>
									<td><label for="MEMBER_TYPE">등급 </label></td>
									<td colspan="4">
									<select id="MEMBER_TYPE" name="MEMBER_TYPE">
										<option value="admin"<c:if test="${member.MEMBER_TYPE eq 'admin'}">selected</c:if>>관리자</option>
										<option value="user"<c:if test="${member.MEMBER_TYPE eq 'user'}">selected</c:if>>유저</option>
									</select>
									</td>
								</tr>
								
								<tr>
									<td><label for="MEMBER_ID">아이디 : </label></td>
									<td colspan="4">
										<input type="text" name="MEMBER_ID"	id="MEMBER_ID" class="inputbox" value="${member.MEMBER_ID }" readonly />
									</td>
								</tr>
								<tr>
									<td><label for="MEMBER_PW">비밀번호 : </label></td>
									<td colspan="4"><input type="password" name="MEMBER_PW"
										id="MEMBER_PW" class="inputbox" value="${member.MEMBER_PW }" /></td>
								</tr>
								<tr>
									<td><label for="MEMBER_NAME">이름 : </label></td>
									<td colspan="4"><input type="text" name="MEMBER_NAME"
										id="MEMBER_NAME" class="inputbox"
										value="${member.MEMBER_NAME }" /></td>
								</tr>
								<tr>
									<td><label for="MEMBER_GENDER">성별 : </label></td>
									<td>
										<c:if test="${member.MEMBER_GENDER eq'1'}">남자</c:if>
										<c:if test="${member.MEMBER_GENDER eq'2'}">남자</c:if>
									</td>
								</tr>
								<tr>
									<td><label for="MEMBER_EMAIL">이메일 주소 : </label></td>
									<td colspan="4"><input type="text" name="MEMBER_EMAIL"
										id="MEMBER_EMAIL" class="inputbox"
										value="${member.MEMBER_EMAIL }" /></td>
								</tr>
								<tr>

									<td><label for="MEMBER_ZIPCODE">우편번호 : </label></td>
									<td><input class="form-control" name="MEMBER_ZIPCODE"
										id="MEMBER_ZIPCODE" type="text" readonly="readonly"
										value="${member.MEMBER_ZIPCODE }"></td>
									<td>
										<button type="button" class="btn btn-default"
											onclick="execPostCode();">
											<i class="fa fa-search"></i> 우편번호 찾기
										</button>
									</td>
								</tr>
								<tr>
									<td><label for="MEMBER_ADDRESS">도로명주소 : </label></td>
									<td colspan="4"><input type="text" name="MEMBER_ADDR1"
										id="MEMBER_ADDR1" class="inputbox"
										value="${member.MEMBER_ADDR1 }" /></td>

								</tr>
								<tr>
									<td><label for="MEMBER_ADDRESS">상세주소 : </label></td>
									<td colspan="4"><input type="text" name="MEMBER_ADDR2"
										id="MEMBER_ADDR2" class="inputbox"
										value="${member.MEMBER_ADDR2 }" /></td>

								</tr>
								<tr>
									<td><label for="MEMBER_PHONE1">연락처 : </label></td>
									<td><select class="inputbox" id="MEMBER_PHONE1"
										name="MEMBER_PHONE1" required="required"
										value="${member.MEMBER_PHONE1 }">
											<option value="010">010</option>
											<option value="011">011</option>
											<option value="016">016</option>
											<option value="017">017</option>
											<option value="019">019</option>
									</select></td>
									<td colspan="3"><input type="text" name="MEMBER_PHONE2"
										size="6" id="MEMBER_PHONE2" maxlength="10" class="inputbox"
										value="${member.MEMBER_PHONE2 }"></td>
								</tr>
								<tr>
									<td><label for="MEMBER_BIRTHYY">생년월일 : </label></td>
									
									<td colspan="3">
										<input type="text" name="MEMBER_BIRTH" size="6" id="MEMBER_BIRTH" maxlength="10" class="inputbox" value="${member.MEMBER_BIRTH }">
									</td>
								</tr>



							</table>
						</form>
					</section>
					<c:choose>
						<c:when test="${MEMBER_TYPE eq 'admin' }">
							<a href="/memberDeleteAction.me?MEMBER_ID=${member.MEMBER_ID}" class="btst">추방하기</a>
						</c:when>
						<c:otherwise>
							<a href="/memberDeleteAction.me?MEMBER_ID=${member.MEMBER_ID}" class="btst">탈퇴하기</a>
						</c:otherwise>
					</c:choose>
						<a href="#none" id="btnModify" class="btst">수정하기</a>
						<a href="/memberListAction.me" id="btnBack" class="btst">돌아가기</a>
				</div>
			</div>
		</div>

	</div>

</body>
</html>