<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	${param.num1} ${param.num2} ${param.num1 + param.num2}

	<!-- 조건문!  -->
	<%-- <c:if test="조건식"></c:if> ->>>JAVA의 IF문과 같은 기능 --%>

	<c:set var="sum" value="${param.num1 + param.num2}" />

	<%-- <c:if test="${sum%2 == 0}">
		<h2>${sum}는(은)짝수입니다.</h2>
	</c:if>
	<c:if test="${sum%2 == 1}">
		<h2>${sum}는(은)홀수입니다.</h2>
	</c:if> --%>


	<%-- <c:choose></c:choose>, <c:when test=""></c:when>, <c:otherwise></c:otherwise> ->> Java의 if,else if, else 문과 같은 기능 --%>
	<!--
	when태그는 if,else if
	otherwise태그는 else
	choose태그는 두 태그를 한군데로 뭉치는 역할
	  -->
	<c:choose>
		<c:when test="${sum%2==0}">
			<h2>${sum}는(은)짝수입니다.</h2>
		</c:when>
		<c:otherwise>
			<h2>${sum}는(은)홀수입니다.</h2>
		</c:otherwise>
	</c:choose>





</body>
</html>