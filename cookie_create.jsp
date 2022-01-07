<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키 생성!</h1>
	
	<%
		//쿠키 생성
		//내장객체가 아니라서 불러와야한다. 
		//Cookie cookie = new Cookie("쿠키이름","실제저장할 데이터");
		//Cookie cookie = new Cookie("message","CookieCreate!");
		
		//쿠키는 숫자와 알파벳 정보만 저장이 가능
		//한글데이터나 공백 특수문자 저장할 때에는 인코딩을 설정
		Cookie cookie = new Cookie("message",URLEncoder.encode("Cookie Create! 완료!","utf-8")); //이러면 컴퓨터 언어로 변경이된다.
		
		//사용자에게 생성한 쿠키를 전달하기 위해서 addCookie() 사용
		response.addCookie(cookie);
		
		
	%>
	
	
	
</body>
</html>