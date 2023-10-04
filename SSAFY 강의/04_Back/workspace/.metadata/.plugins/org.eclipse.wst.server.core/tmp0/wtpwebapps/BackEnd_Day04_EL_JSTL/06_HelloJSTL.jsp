<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<c:out value="Hello SSAFY!"></c:out> <br>
	<c:out value="Hello SSAFY!!"/> <br>
	
	<!-- c:set 을 써보자
		scope : 영역을 설정할 수 있고, 만약에 생략한다면 page
		var : 변수이름
		value : 값
	 -->
	 
	 <c:set var="msg" value="Hello"/>
	 ${msg }<br>
	 <c:set var="msg2">Hello2</c:set>
	 ${msg2 }<br>
	 
	 
	 <c:set var="person" value="<%= new com.ssafy.dto.Person() %>"/>
	 
	 <c:set target="${person }" property="name" value="양띵균2"/>
	 ${person }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
</body>
</html>