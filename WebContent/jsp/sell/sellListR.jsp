<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="context"><%=request.getContextPath()%></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="description" content="sellListR.jsp">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>문구점</title>
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
//         $('#dataTables-example').dataTable();

    });
 
    </script>
</head>
<body>
<jsp:include page="/jsp/common/header.jsp"></jsp:include>v
	<div id="jumbotron" class="container">
		<div class="jumbotron jumbotron-info" style="background-color: lightgray;">
			<h1><font color="black"><strong>주문정보</strong>&nbsp;<i class="fa fa-credit-card fa-1x"></i></font></h1>
			<p>주문 정보를 확인해주세요</p>
		</div>

		<div class="row">
			<div class="col-md-12">
			    <div class="panel panel-default">
			        <!-- /.panel-heading -->
			        <div class="panel-body">
			            <div class="table-responsive">
			                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
			                    <thead>
			                        <tr>
			                        	<th style="text-align: center; vertical-align: middle; width: 30px;">상품코드번호</th>
			                            <th style="text-align: center; vertical-align: middle; width: 80px;">상품이름</th>
			                            <th style="text-align: center; vertical-align: middle; width: 30px;">상품단가</th>
			                            <th style="text-align: center; vertical-align: middle; width: 50px;">상품수량</th>
			                            <th style="text-align: center; vertical-align: middle; width: 30px;">결제금액</th>
			                        </tr>
			                    </thead>
			                    <tbody>
			                    	<c:forEach items="${dsSellList}" var="dsSellList" varStatus="sellIdx">
			                         <tr>
			                         	<td style="text-align: center; vertical-align: middle;">${dsSellList.SELL_CODE}</td>                           
			                            <td style="text-align: center; vertical-align: middle;">${dsSellList.PRODUCT_NAME}</td>
			                            <td style="text-align: center; vertical-align: middle;">${dsSellList.PRODUCT_UNIT_PRICE}원</td>
			                            <td style="text-align: center; vertical-align: middle;">${dsSellList.SELL_COUNT}</td>
			                            <td style="text-align: center; vertical-align: middle;">${dsSellList.SELL_PRICE}원</td>
			                            
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
				<button type="button" class="btn btn-success btn-lg"  style="float:right;" onclick="fn_back()">뒤로가기</button>
			</div>
		</div>
	</div>
	<jsp:include page="/jsp/common/footer.jsp"></jsp:include>
</body>
</html>