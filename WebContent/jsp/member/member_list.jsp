<%@page import="vo.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String id = (String) session.getAttribute("MEMBER_ID");
	String type = (String) session.getAttribute("MEMBER_TYPE");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
<%
/* 		String msg = (String)session.getAttribute("msg");
	
		if(msg != null)
		{
			
			out.println("<script>alert('"+msg+"');</script>");
			session.removeAttribute("msg");
		} */
		
		String msg = (String)session.getAttribute("msg");
		
		if(msg != null)
		{
			if(msg.equals("0"))
				out.println("<script>alert('회원정보가 수정되었습니다.');</script>");
			else if(msg.equals("1"))
				out.println("<script>alert('회원가입을 축하드립니다.');</script>");
			
			session.removeAttribute("msg");
		}
	%>

<style>
#memberListArea {
	width: 400px;
	margin: auto;
}

table {
	width: 380px;
	margin: auto;
	text-align: center;
}

table tr, td {
	border: 1px solid #9c9c9c;
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
					<h1 class="alpha">가입 회원목록</h1>
					<p>가입회원 목록입니다.</p>
					<!-- <section id="memberListArea" class="form-wrap"> -->
					<section id="" class="" >
						<table style="width:100%;">
							<colgroup>
								<col width="20%">
								<col width="10%">
								<col width="20%">
								<col width="20%">
								<col width="20%">
								<col width="10%">
							</colgroup>
							<thead>
								<tr>
									<th>ID</th>
									<th>이름</th>
									<th>이메일</th>
									<th>가입일</th>
									<th>권한</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							
							</tbody>
							<c:forEach var="member" items="${memberList}">
								<tr>
									<td>${member.MEMBER_ID}</td>
									<td>${member.MEMBER_NAME}</td>
									<td>${member.MEMBER_EMAIL}</td>
									<%-- <td><fmt:formatDate value="${member.CRT_DT}" pattern="yyyy.MM.dd"/></td> --%>
									<td>${member.CRT_DT}</td>
									<td>${member.MEMBER_TYPE}</td>
									<td>
										<a href="/Vilsam_yj/memberViewAction.me?MEMBER_ID=${member.MEMBER_ID}">[수정]</a>
										<a href="">[탈퇴]</a>
									</td>
								</tr>
							</c:forEach>
						</table>
						
						<br> <br> <br>
						<h1 class="alpha">주문내역</h1>
						<br>
						<br>
						<%
							if (type.equals("admin")) {
						%>
						<a href="/Vilsam_yj/sellList.se" class="btst">주문내역 보기</a>
						<br>
						<br>
						<%
							} else {
						%>
						<a href="/Vilsam_yj/sellList.se?id=${member.MEMBER_ID}" class="btst">내 주문내역</a><br>
						<br>
						<%
							}
						%>
						</table>
						<br>
						<br>
						<h1 class="alpha">상품리스트 보기</h1>
						<br> <br> 
							<a href="/Vilsam_yj/adproductList.pro" class="btst">상품목록</a> 
							<a href="/Vilsam_yj/productWriteForm.pro" class="btst">상품등록</a>
					</section>
				</div>

			</div>
		</div>
	</div>
	<jsp:include page="/jsp/common/footer.jsp" flush="true"></jsp:include>
</body>
</html>