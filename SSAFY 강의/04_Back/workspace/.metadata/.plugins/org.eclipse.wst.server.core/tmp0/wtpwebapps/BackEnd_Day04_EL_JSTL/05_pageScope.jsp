<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
<%
		//pageContext.setAttribute("name", "page yang");
		request.setAttribute("name", "request yang");
		session.setAttribute("name", "session yang");
		application.setAttribute("name", "application yang");
%>
	<!-- 가장 가까이 있는 영역부터 찾아서 동일하면 출력 -->
	${name } <br>


	<%=pageContext.getAttribute("name") %><br>
	page 속성 : ${pageScope.name}<br>
	request 속성 : ${requestScope.name} <br>
	session 속성 : ${sessionScope.name} <br>
	application 속성 : ${applicationScope["name"]} <br>

</body>
</html>