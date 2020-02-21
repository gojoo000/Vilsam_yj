<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="dao.SellDAO"%>
<%@ page import="vo.SellListBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context"><%=request.getContextPath()%></c:set>
<!DOCTYPE html>
<%
	ArrayList<SellListBean> articleList = null;

	if (request.getAttribute("articleList") != null) {
		articleList = (ArrayList<SellListBean>) request.getAttribute("articleList");
	} else {
		//response.sendRedirect("/Vilsam_yj/productList.pro");
	}
%>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="sellBuyListR.jsp">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>주문내역</title>

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
	var existFolder = '';
	/* 	var imageFolder = ''; */
	var path = '';

	$(document).ready(function() {
		$('#dataTables-example').dataTable();

	});
</script>
</head>
<body>
	<jsp:include page="/jsp/common/header.jsp" flush="true"></jsp:include>.
	<div id="wrap" class="wrap">
		<div class="wrap-inner">
			<!--Signup Section-->
			<div class="section" id="section2">
				<div class="form form--signup">
					<h2>주문내역</h2>
					<p>${MEMBER_ID}님의주문내역입니다.</p>
					<!-- /.panel-heading -->
					<br>
					<table width=80% border=0 class="outLine" id="dataTables-example">

						<tr>
							<th>No</th>
							<th>상품이름</th>
							<th>주문자</th>
							<th>주문수량</th>
							<th>주문상태</th>
							<th>주문일자</th>

						</tr>

						<c:forEach items="${articleList}" var="sell">
							<tr>
								<td style="text-align: center; vertical-align: middle;">${sell.SELLNUM}</td>
								<td style="text-align: center; vertical-align: middle;">${sell.PRODUCT_NUM}</td>
								<td style="text-align: center; vertical-align: middle;">${sell.MEMBER_ID}</td>
								<td style="text-align: center; vertical-align: middle;">${sell.SELL_COUNT}</td>
								<td style="text-align: center; vertical-align: middle;">${sell.SELL_YN}</td>
								<td style="text-align: center; vertical-align: middle;">${sell.SELL_DATE}</td>
							</tr>
						</c:forEach>

					</table>
				</div>
				<!-- /.table-responsive -->
			</div>
		</div>
	</div>
	<!-- /.panel-body -->
	<!-- /.panel -->

	<!-- /.col-lg-12 -->

	<button type="button" class="btn btn-success btn-lg"
		style="float: right;" onclick="fn_back()">뒤로가기</button>
	<jsp:include page="/jsp/common/footer.jsp"></jsp:include>
</body>
</html>