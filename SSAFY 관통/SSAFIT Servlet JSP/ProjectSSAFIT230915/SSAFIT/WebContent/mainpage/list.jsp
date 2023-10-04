<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>운동 영상 리스트</title>
</head>
<body>
	<h2>영상 목록</h2>
	<hr>
	<table>
		<tr>
			<th>번호 </th>
			<th>제목 </th>
			<th>운동부위 </th>
			<th>채널명</th>
			<th>조회수</th>
		</tr>
	
	<c:forEach items="${list}" var="video">
	<tr>
		<td>${video.id }</td>
		<td><a href="main?act=detail&id=${video.id}">${video.title}</td>
		<td>${video.fitPartName }</td>
		<td>${video.channelName }</td>
		<td>${video.viewCnt }</td>
	</tr>
	</c:forEach>
	</table>
	
	
	<hr>
	<h3>운동부위 고르기</h3>
	<form action="main" method="POST">
		<input type="hidden" name="act" value="pick">
		<input type="radio" name="part" value = "어깨"> 어깨<br>
		<input type="radio" name="part"value = "하체"> 하체<br>
		<input type="radio" name="part"value = "가슴"> 가슴<br>
		<br>
		<button>이거만 보기</button>
	</form>
	

</body>
</html>