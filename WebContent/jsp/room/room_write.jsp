<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Title  -->
<title>Product Details</title>

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

<style type="text/css">
</style>
</head>
<body>
	<!-- 게시판 등록 -->
	<jsp:include page="/jsp/common/header.jsp" flush="true"></jsp:include>
	<div id="wrap" class="wrap">
		<div class="wrap-inner">
			<!--Signup Section-->
			<div class="section" id="section2">
				<div class="form form--signup">
					<section id="writeForm">
						<h2>공간등록</h2>
						<form action="/roomWritePro.room" method="post"
							enctype="multipart/form-data" name="productform">
							<table>
								<tr>
									<td><label for="ROOM_NAME">공간명</label></td>
									<td class=""><input name="ROOM_NAME" type="text"
										id="ROOM_NAME" required="required" class="inputbox" /></td>
								</tr>
								<tr>
									<td class=""><label for="ROOM_PRICE">예약가격</label></td>
									<td class=""><input name="ROOM_PRICE" type="text"
										id="ROOM_PRICE" required="required" class="inputbox" /></td>
								</tr>
								<tr>
									<td class=""><label for="ROOM_SIZE">공간면적</label></td>
									<td class=""><input name="ROOM_SIZE" type="text"
										id="ROOM_SIZE" required="required" class="inputbox" /></td>
								</tr>
								<tr>
									<td class=""><label for="ROOM_IMAGE"> 파일 첨부 </label></td>
									<td class=""><input name="ROOM_IMAGE" type="file"
										id="ROOM_IMAGE" required="required" class="inputbox" /></td>
								</tr>
							</table>

							<input type="submit" value="등록" class="btst">&nbsp;&nbsp;
							<input type="reset" value="다시쓰기" class="btst" />

						</form>
					</section>
				</div>
			</div>
		</div>
	</div>
	<!-- 게시판 등록 -->
	<jsp:include page="/jsp/common/footer.jsp" flush="true"></jsp:include>
</body>
</html>