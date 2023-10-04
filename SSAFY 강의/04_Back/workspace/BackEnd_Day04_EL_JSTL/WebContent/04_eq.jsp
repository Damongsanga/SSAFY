<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
</body>
	<!-- 리퀘스트 영역에서 id를 꺼내와보자 -->
	<%= request.getParameter("id") %> <br>
	${param.id } <br>
	
	== : <%= request.getParameter("id") == "ssafy" %> <br>
	equals() : <%= request.getParameter("id").equals("ssafy") %> <br>
	
	== (EL) : ${param.id == "ssafy" } <br>
	eq (EL) : ${param.id eq "ssafy" } <br>
	
</html>