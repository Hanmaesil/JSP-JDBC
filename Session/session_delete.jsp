<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>세션삭제</h1>
	<%
	//특정이름의 세션값을 삭제
	session.removeAttribute("msg");
	
	//세션을 모두 삭제하는 메소드 ex) 로그아웃 기능
	session.invalidate();
	
	%>	
		
		
	
</body>
</html>