<%@page import="vo.NoticeBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	NoticeBean article = (NoticeBean) request.getAttribute("article");
	String nowPage = (String) request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>MVC 게시판</title>
<style type="text/css">
#registForm {
	width: 500px;
	height: 610px;
	border: 1px solid red;
	margin: auto;
}

h2 {
	text-align: center;
}

table {
	margin: auto;
	width: 450px;
}

.td_left {
	width: 150px;
	background: orange;
}

.td_right {
	width: 300px;
	background: skyblue;
}

#commandCell {
	text-align: center;
}
</style>
</head>
<body>
	<!-- 게시판 답변 -->


	<section id="writeForm">
		<h2>게시판글등록</h2>
		<form action="noticeReplyPro.no" method="post" name="noticeform">
			<input type="hidden" name="page" value="<%=nowPage%>" /> <input
				type="hidden" name="NOTICE_NUM"
				value="<%=article.getNOTICE_NUM()%>"> <input type="hidden"
				name="NOTICE_RE_REF" value="<%=article.getNOTICE_RE_REF()%>">
			<input type="hidden" name="NOTICE_RE_LEV"
				value="<%=article.getNOTICE_RE_LEV()%>"> <input
				type="hidden" name="NOTICE_RE_SEQ"
				value="<%=article.getNOTICE_RE_SEQ()%>">
			<table>
				<tr>
					<td class="td_left"><label for="NOTICE_NAME">글쓴이</label></td>
					<td class="td_right"><input type="text" name="NOTICE_NAME"
						id="NOTICE_NAME" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="NOTICE_PASS">비밀번호</label></td>
					<td class="td_right"><input name="NOTICE_PASS" type="password"
						id="NOTICE_PASS" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="NOTICE_SUBJECT">제 목</label></td>
					<td class="td_right"><input name="NOTICE_SUBJECT" type="text"
						id="NOTICE_SUBJECT" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="NOTICE_CONTENT">내 용</label></td>
					<td><textarea id="NOTICE_CONTENT" name="NOTICE_CONTENT"
							cols="40" rows="15"></textarea></td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="답변글등록" />&nbsp;&nbsp; <input
					type="reset" value="다시작성" />
			</section>
		</form>
	</section>
</body>
</html>