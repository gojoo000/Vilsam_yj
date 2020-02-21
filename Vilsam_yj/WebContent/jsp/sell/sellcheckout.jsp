<%@page import="vo.MemberBean"%>
<%@page import="vo.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

   //ArrayList<ProductBean> categoryList = (ArrayList<ProductBean>)request.getAttribute("categoryList");

%>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->
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

	<!-- ##### Main Content Wrapper Start ##### -->
	<div class="main-content-wrapper d-flex clearfix">
		<div class="cart-table-area section-padding-100">
			<div class="container-fluid">
				<div class="row">
					<div class="col-12 col-lg-8">
						<div class="checkout_details_area mt-50 clearfix">

							<div class="cart-title">
								<h2>Checkout</h2>
							</div>

							<form action="#" method="post">
								<div class="row">
									<div class="col-md-6 mb-3">
										<input type="text" class="form-control" id="first_name"
											value="" placeholder="MEMBER_NAME" required>
									</div>
									<div class="col-12 mb-3">
										<input type="email" class="form-control" id="MEMBER_EMAIL
											placeholder="Email" value="">${member.MEMBER_NAME}
									</div>
									<div class="col-12 mb-3">
										<input type="text" class="form-control mb-3"
											id="MEMBER_ZIPCODE" placeholder="Address" value="">${member.MEMBER_ZIPCODE}
									</div>
									<div class="col-12 mb-3">
										<input type="text" class="form-control mb-3"
											id="MEMBER_ADDRESS1" placeholder="Address" value="">${member.MEMBER_ADDRESS1}
									</div>
									<div class="col-md-6 mb-3">
										<input type="number" class="form-control" id="MEMBER_PHONENUM"
											min="0" placeholder="Phone No" value="">${member.MEMBER_PHONENUM}
									</div>
				
									
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="col-12 col-lg-4">
						<div class="cart-summary">
							<h5>Cart Total</h5>
							<ul class="summary-table">
								<li><span>subtotal:</span> <span>${product.PRODUCT_PRICE}</span></li>
								<li><span>delivery:</span> <span>Free</span></li>
							</ul>

							<div class="payment-method">
								<!-- Cash on delivery -->
								<div class="custom-control custom-checkbox mr-sm-2">
									<input type="checkbox" class="custom-control-input" id="cod"
										checked> <label class="custom-control-label" for="cod">Cash
										on Delivery</label>
								</div>
								<!-- Paypal -->
								<div class="custom-control custom-checkbox mr-sm-2">
									<input type="checkbox" class="custom-control-input" id="paypal">
									<label class="custom-control-label" for="paypal">Paypal
										<img class="ml-15" src="img/core-img/paypal.png" alt="">
									</label>
								</div>
							</div>

							<div class="cart-btn mt-100">
								<a href="#" class="btn amado-btn w-100">Checkout</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ##### Main Content Wrapper End ##### -->


</body>

</html>