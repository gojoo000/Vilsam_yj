<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:if test="${articleList eq null }"><script>location.href="/Vilsam_yj/stockList.st?PRODUCT_NUM="+${param.num };</script></c:if>
<!-- Core Style CSS-->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/core-style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/loginst.css" />
<style>
	.form, .form--signup {min-width: 100%;}
	table tr, td, th {padding: 9px;border: 1px solid #9c9c9c;color:#000;}
</style>
</head>
<body>
	<div class="form form--signup">
		<h2>상품 리스트</h2>
		<br>
		<table width=100% border=1 class="outLine">
			<tr class=m3>
				<th>입출고번호</th>
				<th>상품이름</th>
				<th>주문번호</th>
				<th>입고</th>
				<th>출고</th>
				<!-- <th>상품코드</th> -->
				<th>날짜</th>
			</tr>
			<c:forEach var="stock" items="${articleList}">
				<tr>
					<td>${stock.num}</td>
					<td>${stock.product_name}</td>
					<td>${stock.sellnum}</td>
					<td>${stock.in}</td>
					<td>${stock.out}</td>
					<%-- <td>${stock.product_num}</td> --%>
					<td>${stock.dateyy}-${stock.datemm}-${stock.datedd}</td>
					<%-- <td>${stock.sellnum}</td>
					<td>${stock.inqty}</td>
					<td>${stock.outqty}</td>
					<td>${stock.DATEYY}-${stock.DATEMM}-${stock.DATEDD}</td>
					 --%>
				</tr>
			</c:forEach>
		</table>
	</div>

			</div>
</body>
</html>