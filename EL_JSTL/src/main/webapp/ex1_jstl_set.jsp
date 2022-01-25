<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri= "http://java.sun.com/jsp/jstl/core" %>    <!-- 태그 지시자  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<!-- JSTL라이브러리를 이용한 변수 선언하기!  -->
	<%-- <c:set var="변수명" value="값" scope="서버영역" /> ->> 홀태그로 사용하려면 시작태그 마지막에 / 를 입력하면 홀태그로 바뀐다 --%>
	
	<c:set var = "num1" value = "10" /> <!-- 페이지영역에 저장된다  -->
	<c:set var = "num2" value = "20" />
	<c:set var = "sum" value = "${num1+num2}" /> <!-- EL문법을  value에 바로 넣을 수 있다.  -->
		
	
	${num1} <!-- 페이지에 저장된 변수를 EL문법으로 불러온다  -->
	<br>
	${num2}
	<br>
	${sum}
	
	
</body>
</html>