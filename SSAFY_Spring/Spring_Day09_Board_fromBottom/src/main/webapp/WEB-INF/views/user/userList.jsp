<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<%@ include file="../common/bootstrap.jsp"%>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<div class="container">
		<h2>회원가입</h2>
		<hr>

		<table class="table text-center">
			<tr>
				<th>ID</th>
				<th>PW</th>
				<th>NAME</th>
				<th>CURRICULUM</th>
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.password }</td>
					<td>${user.name }</td>
					<td>${user.curriculumCode}</td>
				</tr>
			</c:forEach>
		</table>

		<div class="d-flex justify-content-end">
			<a href="${pageContext.request.contextPath}" class="btn btn-outline-warning">홈으로</a>
		</div>

	</div>
</body>
</html>