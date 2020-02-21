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
	
/* 	String msg = (String)session.getAttribute("msg");
	
	if(msg != null)
	{
		if(msg.equals("0"))
			out.println("<script>alert('회원정보가 수정되었습니다.');</script>");
		else if(msg.equals("1"))
			out.println("<script>alert('회원가입을 축하드립니다.');</script>");
		
		session.removeAttribute("msg");
	} */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보 수정하기</title>
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
						<td>${member.MEMBER_GENDER }</td>
					</tr>
					<tr>
						<td><label for="MEMBER_EMAIL">이메일 주소 : </label></td>
						<td colspan="4"><input type="text" name="MEMBER_EMAIL" id="MEMBER_EMAIL" class="inputbox" value="${member.MEMBER_EMAIL }" /></td>
					</tr>
					<tr>

						<td><label for="MEMBER_ZIPCODE">우편번호 : </label></td>
						<td><input class="form-control" name="MEMBER_ZIPCODE" id="MEMBER_ZIPCODE" type="text" readonly="readonly" value="${member.MEMBER_ZIPCODE }"></td>
						<td>
							<button type="button" class="btn btn-default" onclick="execPostCode();">
								<i class="fa fa-search"></i> 우편번호 찾기</button>
						</td>
					</tr>
					<tr>
						<td><label for="MEMBER_ADDRESS">도로명주소 : </label></td>
						<td colspan="4"><input type="text" name="MEMBER_ADDRESS1" id="MEMBER_ADDRESS1" class="inputbox" value="${member.MEMBER_ADDRESS1 }" /></td>

					</tr>
					<tr>
						<td><label for="MEMBER_ADDRESS">상세주소 : </label></td>
						<td colspan="4"><input type="text" name="MEMBER_ADDRESS2" id="MEMBER_ADDRESS2" class="inputbox" value="${member.MEMBER_ADDRESS2 }" /></td>

					</tr>
					<tr>
						<td><label for="MEMBER_PHONECD">연락처 : </label></td>
						<td><select class="inputbox" id="MEMBER_PHONECD" name="MEMBER_PHONECD" required="required" value="${member.MEMBER_PHONECD }">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="017">017</option>
								<option value="019">019</option>
						</select></td>
						<td colspan="3"><input type="text" name="MEMBER_PHONENUM" size="6" id="MEMBER_PHONENUM" maxlength="10" class="inputbox" value="${member.MEMBER_PHONENUM }"></td>
					</tr>
					<tr>
						<td><label for="MEMBER_BIRTHYY">생년월일 : </label></td>
						<td><select class="inputbox" id="MEMBER_BIRTHYY" name="MEMBER_BIRTHYY" required="required" value="${member.MEMBER_BIRTHYY }">
								<option value="1985">1985</option>
								<option value="1986">1986</option>
								<option value="1987">1987</option>
								<option value="1988">1988</option>
								<option value="1989">1989</option>
								<option value="1990">1990</option>
								<option value="1991">1991</option>
								<option value="1992">1992</option>
								<option value="1993">1993</option>
								<option value="1994">1994</option>
								<option value="1995">1995</option>
								<option value="1996">1996</option>
								<option value="1997">1997</option>
								<option value="1998">1998</option>
								<option value="1999">1999</option>
								<option value="2000">2000</option>
								<option value="2001">2001</option>
								<option value="2002">2002</option>
								<option value="2003">2003</option>
								<option value="2004">2004</option>
								<option value="2005">2005</option>
								<option value="2006">2006</option>
								<option value="2007">2007</option>
								<option value="2008">2008</option>
								<option value="2009">2009</option>
								<option value="2010">2010</option>
								<option value="2011">2011</option>
								<option value="2012">2012</option>
						</select></td>
						<td><input type="text" name="MEMBER_BIRTHMM" size="6" id="MEMBER_BIRTHMM" maxlength="10" class="inputbox" value="${member.MEMBER_BIRTHMM }"></td>
						<td colspan="3"><input type="text" name="MEMBER_BIRTHDD" size="6" id="MEMBER_BIRTHDD" maxlength="10" class="inputbox" value="${member.MEMBER_BIRTHDD }"></td>
					</tr>
					<tr>
						<td><a
							href="/memberModifyAction.me?MEMBER_ID=${member.MEMBER_ID}" class="btst">수정완료</a></td>
					</tr>
				</table>
			</form>
			</section>
		</div>
	</div>
	<jsp:include page="/jsp/common/footer.jsp" flush="true"></jsp:include>
</body>
</html>