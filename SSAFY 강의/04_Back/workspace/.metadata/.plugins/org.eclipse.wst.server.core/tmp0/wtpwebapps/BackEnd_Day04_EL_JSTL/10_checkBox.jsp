<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반찬고르기</title>
</head>
<body>
	<h2>반찬을 골라보자</h2>
	<form action="11_checkBoxResult.jsp">
		<input type="checkbox" name="dish" value="계란말이">계란말이
		<input type="checkbox" name="dish" value="돈까스">돈까스
		<input type="checkbox" name="dish" value="무말랭이">무말랭이 <br>
		<input type="checkbox" name="dish" value="오징어젓갈">오징어젓갈
		<input type="checkbox" name="dish" value="명란젓">명란젓
		<input type="checkbox" name="dish" value="코다리조림">코다리조림
		<button>구매</button>
	</form>
</body>
</html>