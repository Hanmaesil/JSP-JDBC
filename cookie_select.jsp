<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키정보 조회</h1>
	
	<%	
		//사용자의 쿠키정보는 request 객체로부터 접근이 가능!
		//접근시 Cookie배열을 반환 받을 수 있다!
		Cookie[] cookies = request.getCookies();
		
		out.print("쿠키이름 : " + cookies[0].getName() + "<br>"); //쿠키의 이름을 가져오자!
		out.print("쿠키 값 : " + cookies[0].getValue());//쿠키의 값을 가져오자!
		out.print("<hr>");
		out.print(Arrays.toString(cookies)); //->> 배열안에 객체로 이루어져있기 때문에 값으로 표현이 안된다 ->> toString은 일 잘한거임!
		out.print("<hr>");
		for(int i = 0; i < cookies.length; i++){
			out.print("쿠키이름 : " + cookies[i].getName() + "<br>");
			//out.print("쿠키 값 : " + cookies[i].getValue() + "<hr>");
			out.print("쿠키값 : " + URLDecoder.decode(cookies[i].getValue(),"utf-8")); //컴퓨터 언어로 변환된 값을 다시 사람이 볼 수 있게 변환
		}
	
	%>
	
</body>
</html>