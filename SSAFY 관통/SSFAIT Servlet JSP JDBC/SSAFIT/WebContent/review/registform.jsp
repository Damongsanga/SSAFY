<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 등록</title>
</head>
<body>
	<h2>리뷰 등록</h2>
	<hr>
	<form action="main" method="POST">
		<input type="hidden" name="act" value="registReview">
		영상 번호 : <input type="text" name="videoId" readonly value="${videoId}"> <br>
		글쓴이 : <input type="text" name="writer" readonly value="${userId}"> <br>
		내용 : <textarea rows="10" cols="10" name ="content"></textarea><br>
		<button>등록</button>
	</form>
</body>
</html>