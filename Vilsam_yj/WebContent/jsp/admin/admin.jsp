<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="vo.ProductBean"%>
<%
	ProductBean product = (ProductBean) request.getAttribute("product");

%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!-- Title  -->
<title>Vilsam | Home</title>

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

</head>
   <body>
     

	
	<nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
		<div class="container" style="background-color: black;">
			<h2>관리자모드입니다</h2>
			<ul class="nav navbar-nav navbar-right">
				<li>
						<a href="/work/product/retrieveProductListForManage.do"><font color="white"><strong>재고관리</strong></font></a>
				</li>
				<li>
						<a href="/work/sell/retrieveStatisticsForProduct.do"><font color="white"><strong>매출통계</strong></font></a>
				</li>
				<li>
						<a href="/work/product/retrieveStatisticsForStock.do?productCategoryCd=P"><font color="white"><strong>재고현황</strong></font></a>
				</li>
				<li>
						<a href="/work/user/logout.do"><font color="white"><strong>LOGOUT</strong></font></a>
					
				</li>
			</ul>
		</div>
	</nav>
			<div class="container" style="margin-top: 10%; margin-bottom: 10%">
				<div class="row">
					<div class="col-md-4">
					    <a href="/work/product/retrieveProductListForManage.do" class="btn btn-primary" style="width: 100%; height: 250px;" role="button">
							<h1><span class="glyphicon glyphicon-list-alt" style="font-size: 80px; margin-top: 5%;"></span> <br/>재고관리</h1>
						</a>
					</div>
					<div class="col-md-4">
					    <a href="/work/sell/retrieveStatisticsForProduct.do" class="btn btn-danger" style="width: 100%; height: 250px;" role="button">
							<h1><span class="glyphicon glyphicon-signal" style="font-size: 80px; margin-top: 5%;"></span> <br/>매출통계</h1>
					    </a>
					</div>
					<div class="col-md-4">
					    <a href="/work/product/retrieveStatisticsForStock.do?productCategoryCd=P" class="btn btn-info" style="width: 100%; height: 250px;" role="button">
							<h1><span class="glyphicon glyphicon-eye-open" style="font-size: 80px; margin-top: 5%;"></span> <br/>재고현황</h1>
		    		    </a>
					</div>
				</div>
			</div>



</body>
</html>
