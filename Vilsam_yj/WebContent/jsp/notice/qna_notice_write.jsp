<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	<!-- 게시판 등록 -->

	<section id="writeForm">
		<h2>게시판글등록</h2>
		<form action="noticeWritePro.no" method="post"
			enctype="multipart/form-data" name="noticeform">
			<table>
				<tr>
					<td class="td_left"><label for="NOTICE_NAME">글쓴이</label></td>
					<td class="td_right"><input type="text" name="NOTICE_NAME"
						id="NOTICE_NAME" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="NOTICE_PASS">비밀번호</label></td>
					<td class="td_right"><input name="NOTICE_PASS" type="password"
						id="NOTICE_PASS" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="NOTICE_SUBJECT">제 목</label></td>
					<td class="td_right"><input name="NOTICE_SUBJECT" type="text"
						id="NOTICE_SUBJECT" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="NOTICE_CONTENT">내 용</label></td>
					<td><textarea id="NOTICE_CONTENT" name="NOTICE_CONTENT"
							cols="40" rows="15" required="required"></textarea></td>
				</tr>
				<tr>
					<td class="td_left"><label for="NOTICE_FILE"> 파일 첨부 </label></td>
					<td class="td_right"><input name="NOTICE_FILE" type="file"
						id="NOTICE_FILE" required="required" /></td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="등록">&nbsp;&nbsp; <input
					type="reset" value="다시쓰기" />
			</section>
		</form>
	</section>
	<!-- 게시판 등록 -->
</body>
</html>