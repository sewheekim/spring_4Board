<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 게시판</title>
</head>
<body>
	<h2>글 내용</h2>
	<hr>
	목록으로 가기  <a href="list?page=${page }">목록</a>
	<table>
		<tr>
			<td>번호</td>
			<td>${dto.idx }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${dto.writer }</td>
		</tr>
		<tr>
			<td>작성날짜</td>
			<td>${dto.createdAt }</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${dto.readCount }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${dto.content }</td>
		</tr>
	
	</table>
</body>
</html>