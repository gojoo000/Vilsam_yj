<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="dao.RoomDAO"%>
<%@ page import="vo.RoomBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ArrayList<RoomBean> articleList = null;

	if (request.getAttribute("articleList") != null) {
		articleList = (ArrayList<RoomBean>) request.getAttribute("articleList");
	} else {
		response.sendRedirect("/Vilsam_yj/roomtList.room");
	}
%>
<html>
<meta charset="UTF-8">
<title>Vilsam | 공간리스트</title>

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
					<h2>공간 리스트</h2>
					<br>
					<table width=80% border=1 class="outLine">
						<tr class=m3>
							<th>공간코드</th>
							<th>공간이름</th>
							<th>공간사진</th>
							<th>공간평수</th>
							<th>대여가격</th>
							<!-- <th>대여가능 여부</th> -->
						</tr>
						<c:forEach var="room" items="${articleList}">
							<tr>
								<td>${room.room_num}</td>
								<td>${room.room_name}</td>
								<td>${room.room_image}</td>
								<td>${room.room_size}</td>
								<td>${room.room_price}</td>
							</tr>
						</c:forEach>
					</table>
				</div>

			</div>
			<jsp:include page="/jsp/common/footer.jsp" flush="true"></jsp:include>
		</div>

	</div>

</body>
</html>