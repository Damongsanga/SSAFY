<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 수정</title>
</head>
<body>
<h2>리뷰 수정</h2>
	<hr>
	<form action="main" method="POST">
		<input type="hidden" name="act" value="update">		
		<input type="hidden" name="reviewId" value="${review.reviewId}">	
		
		영상 번호 : <input type="text" name="videoId" readonly value = "${review.videoId}"> <br>
		글쓴이 : <input type="text" name="writer" readonly value="${review.writer}"> <br>
		내용 : <textarea rows="10" cols="10" name ="content">${review.content}</textarea><br>
		<button>수정</button>
	</form>
</body>
</html>