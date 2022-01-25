<%@page import="java.util.ArrayList"%>
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
	
	<!--
	 forEach태그 : JAVA의 for문과 같은 기능 
	 var : 변수명(생략가능)
	 begin : 시작값
	 end : 마지막값('작거나 같음' 이다)
	 step : 증가값(생략가능 ->> 기본값은 1이다)
	-->
	<c:forEach var = "i" begin = "1" end ="10">
		${i} <br>
	</c:forEach>
	
	<!-- 
		forEach태그 두번째 구조
		var : 변수명
		items : 배열 또는 리스트 값
	 -->
	 
	 <%
	 ArrayList<String> list = new ArrayList<>();
	 list.add("참치회");
	 list.add("방어회");
	 list.add("연어회");
	 list.add("고등어회");
	 
	 request.setAttribute("list", list);
	 %>
	<br>
	<c:forEach var = "food" items = "${list}">
		${food}
	</c:forEach>
	
	
	
	
</body>
</html>