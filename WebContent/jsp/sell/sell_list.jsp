<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="dao.ProductDAO"%>
<%@ page import="vo.SellListBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ArrayList<SellListBean> articleList = null;

	if (request.getAttribute("articleList") != null) {
		articleList = (ArrayList<SellListBean>) request.getAttribute("articleList");
	} else {
		//response.sendRedirect("/Vilsam_yj/productList.pro");
	}

	String id = (String) session.getAttribute("MEMBER_ID");
%>
<html>
<meta charset="UTF-8">
<title>주문리스트</title>
<head>

<style>
table {
	text-align: center;
	width: 100%;
	margin: 0 auto;
	text-align: center;
	border-radius: 5px;
	background-color: #ffffff;
}

table td, tr {
	border: 1px solid #cccccc;
	padding: 2em;
}
</style>
</head>
<body>
	<jsp:include page="/jsp/common/header.jsp" flush="true"></jsp:include>
	<div id="wrap" class="wrap">
		<div class="wrap-inner">
			<!--Signup Section-->
			<div class="section" id="section2">
				<div class="form form--signup">
					<h2>주문 리스트</h2>
					<br>
					<table width=80% border=0 class="outLine">
						<tr class=m3>
							<th>주문번호</th>
							<th>상품이름</th>
							<th>구매자</th>
							<th>주문수량</th>
							<th>상태</th>
							<th>주문일</th>
						</tr>
						<c:forEach var="sellList" items="${articleList}">
							<tr>
								<td><a>${sellList.sellnum}</a></td>
								<td>${sellList.product_name}</td>
								<td>${sellList.member_id}</td>
								<td>${sellList.sell_count}</td>
								<td>${sellList.sell_yn}</td>
								<td>${sellList.sell_date}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	<jsp:include page="/jsp/common/footer.jsp" flush="true"></jsp:include>
	</div>
</body>
</html>