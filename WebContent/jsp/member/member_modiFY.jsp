<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.MemberBean"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String id = null;
	if (session.getAttribute("MEMBER_ID") == null) {
		out.println("<script>");
		out.println("alert('로그인 해주세요!')");
		out.println("location.href='loginForm.jsp'");
		out.println("</script>");
	} else if (session.getAttribute("MEMBER_ID") != null) {
		id = (String) session.getAttribute("MEMBER_ID");
	}

	MemberBean member = (MemberBean) request.getAttribute("memberInfo");
	
/*   	String msg = (String)session.getAttribute("msg");
	
	if(msg != null)
	{
		if(msg.equals("0"))
			out.println("<script>alert('회원정보가 수정되었습니다.');</script>");
		else if(msg.equals("1"))
			out.println("<script>alert('회원가입을 축하드립니다.');</script>");
		
		session.removeAttribute("msg");
	}  */
%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보 수정하기</title>
<style>
	.section {width:100% !important;}
</style>
</head>

<body>
	<jsp:include page="/jsp/common/header.jsp" flush="true"></jsp:include>

	<div class="section" id="section2">
		<div class="form form--signup">
			<form name="joinform" action="/Vilsam_yj/memberJoinAction.me" method="post" class="form-wrap" id="joinform">
				<table>
					<tr>
						<td><label for="MEMBER_ID">아이디 : </label></td>
						<td colspan="4"><input type="text" name="MEMBER_ID" id="MEMBER_ID" class="inputbox" value="${memberInfo.MEMBER_ID }" readonly/></td>
					</tr>
					<tr>
						<td><label for="MEMBER_PW">비밀번호 : </label></td>
						<td colspan="4"><input type="password" name="MEMBER_PW" id="MEMBER_PW" class="inputbox" value="${memberInfo.MEMBER_PW }" /></td>
					</tr>
					<tr>
						<td><label for="MEMBER_NAME">이름 : </label></td>
						<td colspan="4"><input type="text" name="MEMBER_NAME" id="MEMBER_NAME" class="inputbox" value="${memberInfo.MEMBER_NAME }" /></td>
					</tr>
					<tr>
						<td><label for="MEMBER_GENDER">성별 : </label></td>
						<td>
							<c:if test="${memberInfo.MEMBER_GENDER eq'1'}">남자</c:if>
							<c:if test="${memberInfo.MEMBER_GENDER eq'2'}">남자</c:if>
						</td>
					</tr>
					<tr>
						<td><label for="MEMBER_EMAIL">이메일 주소 : </label></td>
						<td colspan="4"><input type="text" name="MEMBER_EMAIL" id="MEMBER_EMAIL" class="inputbox" value="${memberInfo.MEMBER_EMAIL }" /></td>
					</tr>
					<tr>

						<td><label for="MEMBER_ZIPCODE">우편번호 : </label></td>
						<td><input class="form-control" name="MEMBER_ZIPCODE" id="MEMBER_ZIPCODE" type="text" readonly="readonly" value="${memberInfo.MEMBER_ZIPCODE }"></td>
						<td>
							<button type="button" class="btn btn-default" onclick="execPostCode();">
								<i class="fa fa-search"></i> 우편번호 찾기</button>
						</td>
					</tr>
					<tr>
						<td><label for="MEMBER_ADDRESS">도로명주소 : </label></td>
						<td colspan="4"><input type="text" name="MEMBER_ADDR1" id="MEMBER_ADDR1" class="inputbox" value="${memberInfo.MEMBER_ADDR1 }" /></td>

					</tr>
					<tr>
						<td><label for="MEMBER_ADDRESS">상세주소 : </label></td>
						<td colspan="4"><input type="text" name="MEMBER_ADDR2" id="MEMBER_ADDR2" class="inputbox" value="${memberInfo.MEMBER_ADDR2 }" /></td>

					</tr>
					<tr>
						<td><label for="MEMBER_PHONE1">연락처 : </label></td>
						<td><select class="inputbox" id="MEMBER_PHONE1" name="MEMBER_PHONE1" required="required" value="${memberInfo.MEMBER_PHONE1 }">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="017">017</option>
								<option value="019">019</option>
						</select></td>
						<td colspan="3"><input type="text" name="MEMBER_PHONE2" size="6" id="MEMBER_PHONE2" maxlength="10" class="inputbox" value="${memberInfo.MEMBER_PHONE2 }"></td>
					</tr>
					<tr>
						<td><label for="MEMBER_BIRTHYY">생년월일 : </label></td>
						<td colspan="2"><input type="text" name="MEMBER_BIRTH" size="6" id="MEMBER_BIRTH" maxlength="10" class="inputbox" value="${memberInfo.MEMBER_BIRTH }"></td>
					</tr>
					<tr>
						<td colspan="3"><a href="/Vilsam_yj/memberModifyAction.me?MEMBER_ID=${memberInfo.MEMBER_ID}" class="btst">수정완료</a></td>
					</tr>
				</table>
			</form>
			</section>
		</div>
	</div>
	<jsp:include page="/jsp/common/footer.jsp" flush="true"></jsp:include>
</body>
</html>