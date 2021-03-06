<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="dao.RoomDAO"%>
<%@ page import="vo.RoomBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<meta charset="UTF-8">
<title>Vilsam | 상품리스트</title>
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
	table td, tr {border: 1px solid #cccccc;padding: 2em;}
	#section2 {height: auto;}
	.section h1, .section h2 {font-size:20px;}
	.discription {margin-bottom:15px;}
	.discription p:first-child {margin-bottom:17px;margin-top:20px;font-size:15px;font-weight:700;}
</style>
</head>
<body>
	<jsp:include page="/jsp/common/header.jsp" flush="true"></jsp:include>
	<div id="wrap" class="wrap">
		<div class="wrap-inner">
			<!--Signup Section-->
			<div class="section" id="section2">
				<div class="form form--signup">
					<h2>방 리스트</h2>
					<table class="outLine" style="width:80%;">
						<c:forEach var="room" items="${articleList}">
							<hr>
							<ul class="list" style="">
  								<li class="list-item">
    							<div class="list-content"> 
      								<h1>${room.room_name}</h1>
      								<img src="/Vilsam_yj/upload/room/${room.room_image}" alt="" />
      								<div class="discription">
	      								<p>Room Size : ${room.room_size}</p>
	      								<p>대여료 : ${room.room_price}</p>
	      							</div>
    							</div>	
  								</li>
								</ul>
								<button onclick="location.href='/Vilsam_yj/roomDetail.room?room_num=${room.room_num}'">상세보기</button>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="/jsp/common/footer.jsp" flush="true"></jsp:include>
</body>
</html>