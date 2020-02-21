<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vilsam | 로그인</title>
   <!-- Favicon  -->
    <link rel="icon" href="${pageContext.request.contextPath }/img/core-img/favicon.ico">
<!-- Core Style CSS-->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/core-style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/loginst.css" />
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

<style>
#loginformArea {
	margin: auto;
	width: 400px;
}

table {
	width: 380px;
	margin: auto;
	text-align: center;
}
</style>

	<%
		String msg = (String)session.getAttribute("msg");
	
		if(msg != null)
		{
			if(msg.equals("0"))
				out.println("<script>alert('회원정보가 수정되었습니다.');</script>");
			else if(msg.equals("1"))
				out.println("<script>alert('회원가입을 축하드립니다.');</script>");
			
			session.removeAttribute("msg");
		}
	%>
<script type="text/javascript">


$(function(){
	
	
	
    $('#btnId').click(function(){    	
    	$('#loginform').submit();
    });
    
    $('#btnJoin').click(function(){    	
    	location.href = "/jsp/joinForm.jsp";
    	/* $('#loginform').submit(); */
    });
    
    
});
/* 
function goPage() {
	location.href = "../loginForm.jsp";
}
  */
</script>
</head>
<body>
	<jsp:include page="common/header.jsp" flush="true"></jsp:include>
	<div id="wrap" class="wrap">
		<div class="wrap-inner">
			<!--Signup Section-->
			<div class="section" id="section2">
				<div class="form form--signup">
					<h1 class="alpha">로그인</h1>
					<p>Vilsam에 오신것을 환영합니다.</p>
					<section id="loginformArea">
						<form name="loginform" id="loginform" action="/Vilsam_yj/memberLoginAction.me"
							method="post" class="form-wrap">
							<table>
								<tr>
									<td colspan="2"></td>
								</tr>
								<tr>
									<td><label for="MEMBER_ID">아이디 : </label></td>
									<td><input type="text" name="MEMBER_ID" id="MEMBER_ID"
										class="inputbox" /></td>
								</tr>
								<tr>
									<td><label for="MEMBER_PW">비밀번호 : </label></td>
									<td><input type="password" name="MEMBER_PW" id="MEMBER_PW"
										class="inputbox" /></td>
								</tr>
								<tr>
									<td colspan="2">
										<button type="button"  id="btnId">로그인</button>&nbsp;&nbsp;
										<button type="button" id="btnJoin">회원가입</button>
										<!-- <a href="#none" id="btnId">Login</a> -->
									</td>
								</tr>
							</table>
						</form>
					</section>
				</div>
			</div>
		</div>
	</div>
		<jsp:include page="common/footer.jsp" flush="true"></jsp:include>
</body>
</html>