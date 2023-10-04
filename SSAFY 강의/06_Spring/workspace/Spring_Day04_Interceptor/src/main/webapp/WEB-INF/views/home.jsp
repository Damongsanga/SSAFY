<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<c:choose>
		<c:when test="${empty id}">
			<a href="login"> 로그인 페이지 </a>
		</c:when>
		<c:otherwise>
			${id} 님 반갑습니다. <a href="logout"> 로그아웃 </a>
		</c:otherwise>
	</c:choose>


	<h1>Hello world!</h1>
	<P>The time on the server is ${serverTime}.</P>
	
	
	
	<!-- regist.jsp 로 보내고 싶은 버튼 만들기 -->
	<!-- regist : 마지막 /부터 붙어서 경로 작성 -->
	<!-- /regist : root context부터 경로 작성 -->
	<a href="regist"> 게시물 등록 </a>
	
</body>
</html>
