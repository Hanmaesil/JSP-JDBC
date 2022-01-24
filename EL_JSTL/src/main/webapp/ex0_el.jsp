<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- Hello World! 출력  -->
	<!-- 방식1  -->
	<%= "Hello World!" %>
	<!-- 방식2  -->
	<h2><% out.print("Hello World!!"); %></h2>
	<!-- 방식3(EL문법 ->> 출력하는 용도의 문법이다!(주로 JSTL태그와 같이 사용된다)  -->
	<h2>${ "Hello World!!!" }</h2>
	
</body>
</html>