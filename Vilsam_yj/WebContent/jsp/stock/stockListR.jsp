<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context"><%=request.getContextPath()%></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="stockListR.jsp">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>재고</title>

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

<script>
	var existFolder = '';
	var imageFolder = '';
	var path = '';

	$(document).ready(function() {
		$('#dataTables-example').dataTable();
	});

/* 	function fn_modifyProduct(paramProductCode) {
		location.href = "${context}/work/product/updateProduct.do?productCode="
				+ paramProductCode;
	}
 */
	function fn_createProduct() {
		location.href = "/Vilsam_yj/jsp/product/product_write.jsp";
	}
</script>
</head>
<body>
	<div id="jumbotron" class="container">
		<div class="jumbotron jumbotron-info"
			style="background-color: lightgray;">
			<h1>
				<font color="black"><strong>재고관리</strong>&nbsp;<span
					class="glyphicon glyphicon-list-alt"></span></font>
			</h1>
			<p>재고관리 페이지입니다.</p>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="page-header" style="float: right;">
					<button type="button" class="btn btn-info btn-lg"
						onclick="fn_createProduct()">제품추가</button>
				</div>
			</div>
			<div class="col-md-12">
				<div class="panel panel-default">
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th
											style="text-align: center; vertical-align: middle; width: 30px;">인덱스</th>
										<th
											style="text-align: center; vertical-align: middle; width: 80px;">입출고</th>
										<th
											style="text-align: center; vertical-align: middle; width: 30px;">제품번호</th>
										<th
											style="text-align: center; vertical-align: middle; width: 30px;">개수</th>
										<th
											style="text-align: center; vertical-align: middle; width: 50px;">제품재고</th>
										<th
											style="text-align: center; vertical-align: middle; width: 50px;">처리날짜</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${dsProductList}" var="dsProductList"
										varStatus="productIdx">
										<tr>
											<td style="text-align: center; vertical-align: middle;">${dsProductList.NUM}</td>
											<td style="text-align: center; vertical-align: middle;">${dsProductList.IO}</td>
											<td style="text-align: center; vertical-align: middle;">${dsProductList.PRODUCT_NUM}</td>
											<td style="text-align: center; vertical-align: middle;">${dsProductList.PRODUCT_PRICE}원</td>
											<td style="text-align: center; vertical-align: middle;">${dsProductList.COUNT}</td>
											<td style="text-align: center; vertical-align: middle;">${dsProductList.DATE}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- /.table-responsive -->
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-md-1 col-md-offset-11">
				<button type="button" class="btn btn-success btn-lg"
					style="float: right;" onclick="fn_back()">뒤로가기</button>
			</div>
		</div>
	</div>
</body>
</html>