<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="dao.ProductDAO"%>
<%@ page import="vo.StockBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ArrayList<StockBean> articleList = null;

	if (request.getAttribute("articleList") != null) {
		articleList = (ArrayList<StockBean>) request.getAttribute("articleList");
	} else {
		//response.sendRedirect("/Vilsam_yj/productList.pro");
	}
%>
<!DOCTYPE html>
<html>
<head>
<!-- Core Style CSS-->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/core-style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/loginst.css" />
<style>
table {
	text-align: center;
	width: 100%;
	text-align: center;
	border-radius: 5px;
}
</style>
<script>
	/* 	$(function() {
	 $('#btnApply').click(function() {
	 $('#stockApply').submit();
	 });
	 }); */
	function btnInsert() {
		$(function() {
			$('#btnInsert').click(function() {
				$('#stockApply').submit();
			});
		});

	}

	/* 	$(function() {
	 $('#btnApply').click(function() {
	
	 });
	 }); */
</script>
</head>
<body>
	<div id="wrap">
		<c:set var="product" value="${articleList}" />
		<form id="stockApply" action="/Vilsam_yj/stockWritePro.st" method="post">
			<table>
				<h1>재고관리</h1>
				<h2>
					제품번호 : <input type="text" value="${param.num }" id="PRODUCT_NUM" name="PRODUCT_NUM" readonly />
				</h2>
				<tr>
					<td><select name="IO">
							<option value="입고">입고 </option>
							<option value="출고">출고 </option>
					</select></td>
					<td><input type="text" id="COUNT" name="COUNT" maxlength="5"></td>
				</tr>

			</table>
			<table>
				<tr>
					<p>날짜</p>
					<td><select class="inputbox" required="required" id="DATEYY" name="DATEYY">
							<option value="2019">2019</option>
							<option value="2020">2020</option>
					</select></td>
					<td><input type="text" name="DATEMM" size="6" id="DATEMM" maxlength="10" class="inputbox"></td>
					<td><input type="text" name="DATEDD" size="6" id="DATEDD" maxlength="10" class="inputbox"></td>
				</tr>
				<tr>
					<td colspan="3"><br> <input type="submit" class="bsts" onclick="btnInsert();" id="btnApply" value="적용"></button></td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>