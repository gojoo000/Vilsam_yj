<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="dao.ProductDAO"%>
<%@ page import="vo.ProductBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ArrayList<ProductBean> articleList = null;

	if (request.getAttribute("articleList") != null) {
		articleList = (ArrayList<ProductBean>) request.getAttribute("articleList");
	} else {
		//response.sendRedirect("/Vilsam_yj/productList.pro");
	}
	String id = (String) session.getAttribute("MEMBER_ID");
%>
<!DOCTYPE html>
<html lang="en">

<head>
<style>
	.main-content-wrapper{
		width:100%;
	}
	.single-product-area{
	border-radius:20px;
		margin: 0 auto;
		background-color:white;
	}
	.container-fluid{
			margin-top:2%;
	}
	.product-meta-data{
		
	}
</style>

</head>

<body>
	<jsp:include page="/jsp/common/header.jsp" flush="true"></jsp:include>

	<!-- Search Wrapper Area End -->
	<!-- ##### Main Content Wrapper Start ##### -->
	<div class="main-content-wrapper">

		<!-- Mobile Nav (max width 767px)-->
		<%-- <c:set var="product" value="${articleList}" /> --%>
		<%-- <c:set var="productBean" value="${articleList}" /> --%>
		<!-- Product Details Area Start -->
		<div class="single-product-area">
			<div class="container-fluid">
				<div class="col-12 col-lg-5">
					<div class="single_product_desc">
						<!-- Product Meta Data -->
						<div class="product-meta-data">
							<form action="/Vilsam_yj/sellWritePro.se">
								<img id="PRODUCT_IMAGE"
									src="/Vilsam_yj/upload/${product.product_image }"> <br>
								<br> <input type="hidden" id="PRODUCT_NUM"
									name="PRODUCT_NUM" value="${product.product_num }"> <input
									type="hidden" id="MEMBER_ID" name="MEMBER_ID"
									value="${MEMBER_ID}"> <input type="hidden" name="IO"
									value="출고" />
								<div class="line"></div>
								가격
								<p class="product-price">&nbsp;&nbsp;&#8361; ${product.product_price }</p>
								<br>
									<h6>${product.product_name }</h6>
								<br>
								<p class="product_jaego">현재 재고 :
									&nbsp;${product.product_jaego }개 남음</p>
						</div>
						<br>
						<div class="cart clearfix" method="post">
							<div class="cart-btn d-flex mb-50">
								<p>주문수량</p>
								<div class="quantity">
									<span class="qty-minus"
										onclick="var effect = document.getElementById('SELL_COUNT'); var SELL_COUNT = effect.value; if( !isNaN( SELL_COUNT ) &amp;&amp; SELL_COUNT &gt; 1 ) effect.value--;return false;">
										<i class="fa fa-caret-down" aria-hidden="true"></i>
									</span> <input type="number" class="qty-text" id="SELL_COUNT" step="1"
										min="1" max="300" name="SELL_COUNT" value="1"> <span
										class="qty-plus"
										onclick="var effect = document.getElementById('SELL_COUNT'); var SELL_COUNT = effect.value; if( !isNaN( SELL_COUNT )) effect.value++;return false;"><i
										class="fa fa-caret-up" aria-hidden="true"></i></span>
								</div>
							</div>
						</div>
						<div class="short_overview my-5">
							<p>상품설명</p>
						</div>
						<!-- 	<button type="submit" name="addtocart" value="5" class="btst">장바구니
								담기</button> -->
						<input type="submit" value="주문하기" class="btst">
						</form>

					</div>
				</div>
			</div>
		</div>
		<!-- Product Details Area End -->
	</div>

	<jsp:include page="/jsp/common/footer.jsp" flush="true"></jsp:include>
</body>

</html>