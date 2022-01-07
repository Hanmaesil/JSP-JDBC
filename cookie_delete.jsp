<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키 삭제!</h1>
	<%
	//유효기간을 만료시켜서 삭제시키는 방법
	Cookie cookie = new Cookie("message","삭제될데이터");
	cookie.setMaxAge(0); //유효기간 기본값이 초단위(초단위를 넣으면 된다.) , 0을 넣으면 쿠키정보를 바로 삭제한다.
	response.addCookie(cookie);
	
	%>
</body>
</html>