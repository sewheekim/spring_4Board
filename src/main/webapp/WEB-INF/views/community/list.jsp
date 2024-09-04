<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 게시판</title>
<link rel="stylesheet" href="../resources/css/table.css">
</head>
<body>
	<h2>글 목록</h2>
	<hr>
	<table>
		<tr>
			<td>번호</td>
			<td>글제목</td>
			<td>작성자</td>
			<td>조회수</td>
			<td>날짜</td>
		</tr>	
		<!-- 컨트롤러에서 페이지글목록을 list 이름으로 저장해야 합니다. -->
		<c:forEach items="${list }" var="dto">
			<tr>
				<td><c:out value="${dto.rnum }"/></td>
				<td><c:out value="${dto.title }"/></td>
				<td><c:out value="${dto.writer }"/></td>
				<td><c:out value="${dto.readCount }"/></td>
				<td><c:out value="${dto.createdAt }"/></td>
			</tr>
		</c:forEach>
	
	</table>
	<p>현재페이지의 정보 : <c:out value="${pageDto }"/></p>
	
	
	
	
	<p>
		<a href="write">글쓰기</a>
	</p>
</body>
</html>