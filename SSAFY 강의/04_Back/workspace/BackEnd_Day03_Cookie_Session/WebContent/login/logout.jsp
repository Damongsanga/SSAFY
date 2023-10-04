<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 로그인 유저 지우기 -->
<%-- 	<% session.removeAttribute("loginUser"); %> --%>
	
	<!-- 세션 지우기 -->
	<% session.invalidate(); %>
	
	<!-- 로그인폼으로 튕기기 -->
	<script type="text/javascript">
		alert("로그아웃 했습니당~~ 다음에 또 이용해주세요.")
		location.href="loginForm.jsp";
	
	</script>
	
</body>
</html>