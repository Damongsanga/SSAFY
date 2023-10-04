<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과일선택</title>
</head>
<body>
	<c:if test="${param.fruit == 1}">
		<div style="color: yellow">파인애플</div>
	</c:if>	
	<c:if test="${param.fruit == 2}">
		<div style="color: pink">망고스틴</div>
	</c:if>	
	<c:if test="${param.fruit == 3}">
		<div style="color: green">멜론</div>
	</c:if>	
	<c:if test="${param.fruit == 4}">
		<div style="color: red">사과</div>
	</c:if>	
	 
	<c:choose>
		<c:when test="${param.fruit == 3}">
			<div style="color: green">멜론</div>
		</c:when>
		<c:otherwise>
			<div>그외의 과일들이다.</div>
		</c:otherwise>
	</c:choose>
</body>
</html>