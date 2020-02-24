<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="dao.RoomDAO"%>
<%@ page import="vo.RoomBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
/* 	ArrayList<RoomBean> article = null;

	if (request.getAttribute("article") != null) {
		//article = (ArrayList<RoomBean>) request.getAttribute("article");
	} else {
		//response.sendRedirect("/roomList.pro");
	} */
	String id = (String) session.getAttribute("MEMBER_ID");
%> --%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Title  -->
<title>Room Details</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel='stylesheet' href='/Vilsam_yj/css/fullcalendar/fullcalendar.css'>
<script src="/Vilsam_yj/js/fullcal/moment.min.js"></script>
<script src='/Vilsam_yj/js/fullcalendar/fullcalendar.js'></script>

<style>
.main-content-wrapper{width:100%;}
.single-room-area{
	border-radius:20px;
	margin: 0 auto;
	background-color:white;
	width: 80%;
	text-align:center;
}
.container-fluid{margin-top:2%;}
.room-meta-data {margin-bottom: 25px;}
.room-meta-data h2 {font-size:25px;margin-top:10px;;margin-bottom:20px;}
.room-meta-data img {margin-bottom: 20px;}
.room-meta-data p {font-size:18px;}
.room-meta-data p:first-child {margin-bottom:10px;}
.room-meta-data p:last-child {font-weight:900;}

.col-12 {padding-right:0;padding-left:0;margin:0 auto;}
</style>
<script>
$(function() {
	  $("#reserDate").datepicker({
	        showOn: "both", 
	      /*   buttonImage: "button.png", 
	        buttonImageOnly: true, */
	        altField: "#reserDate",
	        changeMonth: true,
	        changeYear: true,
	        dayNamesShort: 
	            [ "일", "월", "화", "수", "목", "금", "토" ] ,
	        altFormat: "yy-mm-dd"
	  });
	});
/* 	$(function() {
		$('#btnReset').click(function() {
			$('#joinform').submit();
		});
	});  */
	
	$(document).ready(function() {
		var reserck = 0;
		
		$("#btnReserChk").click(function() {
	        //room_num 를 param.
	        var room_num =  $("#room_num").val(); 
	        var reser_date =  $("#reserDate").val();
	        alert(reser_date);
	        $.ajax({
	            /* async: true, */
	            type : 'POST',
	            data : 'ROOM_NUM='+room_num+'&RESER_DATE='+reser_date, 
	            url : "/reserChkAction.reser",
	            
	            /* contentType: "application/json; charset=UTF-8", */
	            success : function(data) {
	                if (data==1) {
	                    alert("예약이 꽉 찼습니다. 다른 날짜에 예약해주세요.");
	          
	                } else {
	                    alert("예약완료!");
	                    reserck = 1;
	                    $('#reserForm').submit();
	                }
	            },
	            error : function(error) {
	                alert("error : " + error);
	            }
	        });
		  }); 
	
		 var test = $("#room_num").val();
		
		$('#calendar').fullCalendar({
	        header: {
	            left: 'prev,next today',
	            center: 'title',
	            right: 'month,listMonth'
	        },
	        defaultDate: moment().format('YYYY-MM-DD'),
	        editable: true,
	        navLinks: true,
	        eventLimit: true,
	        events: function(start, end, timezone, callback) {
	            $.ajax({
	                url: '/rsv/calendar.do',
	                type : 'post',
	                data: 'room_num='+test,
	                dataType: 'json',
	                success: function(data) {//5.map이 일로들어옴
	                   var json = data.calendarList;
	                /*    alert(json);
	                   alert(data); */
	                    var events = [];
	                    $.each(json, function(i, obj) { //i(json에 담긴크기만큼(인덱스)) 반복
	                       events.push({
	                          id: i+1, 
	                          title: obj.room_name,
	                          start: obj.reser_date, //시작날짜 
	                          allDay: true});
	                    });
	                    callback(events); //뿌려주기
	                }
	            });
	        }
	    });
	});
</script>
</head>

<body>
	<jsp:include page="/jsp/common/header.jsp" flush="true"></jsp:include>
	<!-- Search Wrapper Area End -->
	<!-- ##### Main Content Wrapper Start ##### -->
	<div class="main-content-wrapper">

		<!-- Mobile Nav (max width 767px)-->
		<%-- <c:set var="room" value="${articleList}" /> --%>
		<!-- Room Details Area Start -->
		<div class="single-room-area">
			<div class="container-fluid">
				<div class="col-12 col-lg-5">
					<div class="single_room_desc">
						<!-- Room Meta Data -->
						<div class="room-meta-data">
							<form action="/Vilsam_yj/reservationWritePro.reser" id="reserForm">
							<input type="hidden" id="MEMBER_ID" name="MEMBER_ID" value="${MEMBER_ID}"/>
							<h2>${room.room_name }</h2>
							<img class="room-image" src="/Vilsam_yj/upload/room/${room.room_image}">
							<input type="hidden" id="room_num" name="room_num" value="${room.room_num }">
							<p>대여비</p>
							<p class="room-price">&nbsp;&nbsp;&#8361; ${room.room_price }</p>
						</div>
						<h2>예약날짜 선택</h2>
						<input type="text" id="reserDate" name="reserDate">
						<div id="calendar" style="max-width: 100%; display: inline-block; width:100%; height:100%; margin:5% auto;"></div>
						<a href="#none" class="button" id="btnReserChk">예약하기</a>
						</form>
					</div>
				</div>
			</div></div>
		</div>

		<!-- Room Details Area End -->

	<jsp:include page="/jsp/common/footer.jsp" flush="true"></jsp:include>
</body>

</html>