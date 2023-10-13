<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영상 정보 수정</title>
</head>
<body>
<h2>영상 정보 수정</h2>
	<hr>
	<form action="main" method="POST">
		<input type="hidden" name="act" value="updateVideo">		
		
		작성자 : <input type="text" name="writer" value="${video.writer}"> <br>
		운동부위 : <input type="text" name="fitPartName" value="${video.fitPartName}"> <br>
		채널명 : <input type="text" name="channelName" value="${video.channelName}"> <br>
		유튜브 아이디 : <input type="text" name="youtubeId" value="${video.youtubeId}"> <br>

		<button>수정</button>
	</form>
</body>
</html>