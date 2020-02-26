<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vilsam | 회원가입</title>

<!-- Favicon  -->
<link rel="icon"
	href="${pageContext.request.contextPath }/img/core-img/favicon.ico">
<!-- Core Style CSS-->
<link rel="stylesheet" href="/Vilsam_yj/css/core-style.css" />
<!-- <link rel="stylesheet" href="/Vilsam_yj/style.css" /> -->
<link rel="stylesheet" href="/Vilsam_yj/css/loginst.css" />
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
/* 	$(function() {
		$('#btnReset').click(function() {
			$('#joinform').submit();
		});
	});  */
	
	$(document).ready(function() {
		var idck = 0;
		
		$("#btnIdChk").click(function() {
	        
	        //userid 를 param.
	        var userid =  $("#MEMBER_ID").val(); 
	        
	        $.ajax({
	            /* async: true, */
	            type : 'POST',
	            data : 'MEMBER_ID='+userid,
	            url : "/Vilsam_yj/idChkAction.do",
	            
	            /* contentType: "application/json; charset=UTF-8", */
	            success : function(data) {
	                if (data==1) {
	                    alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
	                    $("#MEMBER_ID").focus();
	                } else {
	                    alert("사용가능한 아이디입니다.");
	                    idck = 1;
	                }
	            },
	            error : function(error) {
	                alert("error : " + error);
	            }
	        });
	    });
		
		
		$("#btnJoin").click(function() {
			
			
			if ($("#MEMBER_ID").val() == "") {
				alert("아이디를 입력하세요!");
				$("#MEMBER_ID").focus();
				return false;
			}
			if(idck==0){
				alert("ID중복 검사를 해주세요.");
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
			$('#joinform').submit();
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
					<h1 class="alpha">회원가입</h1>
					<p>Vilsam에 오신것을 환영합니다.</p>
					<section id="joinformArea">
						<form name="joinform" action="/Vilsam_yj/memberJoinAction.me"
							method="post" class="form-wrap" id="joinform">
							<table>
								<tr>
									<td>
										<label for="MEMBER_ID">아이디 : </label>
									</td>
									<td colspan="4">
										<input type="text" name="MEMBER_ID"	id="MEMBER_ID" class="inputbox" />
										<a href="#none" class="btst mt10 mb10" id="btnIdChk">중복검사</a>
									</td>
								</tr>
								<tr>
									<td><label for="MEMBER_PW">비밀번호 : </label></td>
									<td colspan="4"><input type="password" name="MEMBER_PW"
										id="MEMBER_PW" class="inputbox" /></td>
								</tr>
								<tr>
									<td><label for="MEMBER_NAME">이름 : </label></td>
									<td colspan="4"><input type="text" name="MEMBER_NAME"
										id="MEMBER_NAME" class="inputbox" /></td>
								</tr>
								<tr>
									<td><label for="MEMBER_GENDER">성별 : </label></td>
									<td><input type="radio" name="MEMBER_GENDER" value="1"	checked="checked" id="MEMBER_GENDER" class="inputbox" />남자
									<td><input type="radio" name="MEMBER_GENDER" value="2" class="inputbox" />여자</td>
								</tr>
								<tr>
									<td><label for="MEMBER_EMAIL">이메일 주소 : </label></td>
									<td colspan="4"><input type="text" name="MEMBER_EMAIL"
										id="MEMBER_EMAIL" class="inputbox" /></td>
								</tr>
								<tr>

									<td><label for="MEMBER_ZIPCODE">우편번호 : </label></td>
									<td><input class="form-control form-wrap inputbox" name="MEMBER_ZIPCODE" id="MEMBER_ZIPCODE" type="text" readonly="readonly" onclick="execPostCode();"></td>
									<td>
										<button type="button" class="btn btn-default" onclick="execPostCode();">
											<i class="fa fa-search"></i> 우편번호 찾기
										</button>
									</td>
								</tr>
								<tr>
									<td><label for="MEMBER_ADDRESS">도로명주소 : </label></td>
									<td colspan="4"><input type="text" name="MEMBER_ADDR1"
										id="MEMBER_ADDR1" class="inputbox" /></td>

								</tr>
								<tr>
									<td><label for="MEMBER_ADDRESS">상세주소 : </label></td>
									<td colspan="4"><input type="text" name="MEMBER_ADDR2"
										id="MEMBER_ADDR2" class="inputbox" /></td>

								</tr>
								<tr>
									<td><label for="MEMBER_PHONE1">연락처 : </label></td>
									<td colspan="3">
										<input type="text" name="MEMBER_PHONE2"	size="12" id="MEMBER_PHONE2" maxlength="10" class="inputbox">
									</td>
								</tr>
								<tr>
									<td><label for="MEMBER_BIRTH">생년월일 : </label></td>
									<td>
										<input type="text" class="inputbox"	id="MEMBER_BIRTH" name="MEMBER_BIRTH" required="required">
									</td>
									
								</tr>
								<tr>
									<td colspan="2"><a class="btst mt10" id="btnJoin">회원가입</a></td>
									<td colspan="2"><a class="btst mt10" id="btnReset">다시작성</a></td>
								</tr>
							</table>
						</form>
					</section>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/jsp/common/footer.jsp" flush="true"></jsp:include>
</body>
</html>