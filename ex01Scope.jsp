<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		//scope : 서버에 저장할 수 있는 영역
		//scope의 객체(영역의 종류)
		//1. pageContext : 하나의 웹 페이지 안에서 정보를 저장하는 영역
		//2. request : 하나 이상의 웹페이지안에서 정보를 저장하는 영역(웹페이지 이동방식 --> froward) //주로 사용!
		// ->> forward 방식으로 이동할 경우 데이터를 가지고 넘어간다.
		//3. session : 하나의 브라우저 안에서 정보를 저장하는 영역 //주로 사용!
		//4. application : 하나의 웹 어플리케이션 안에서 정보를 저장하는 영역
		
		pageContext.setAttribute("page", "100");
		request.setAttribute("request", "200");
		session.setAttribute("session", "300");
		application.setAttribute("application", "400");
		
	
	%>
	
	
	
	page영역 : <%= pageContext.getAttribute("page") %><br>
	request영역 : <%= request.getAttribute("request") %><br>
	session영역 : <%= session.getAttribute("session") %><br>
	application영역 : <%= application.getAttribute("application") %><br>
	
	<% response.sendRedirect("ex02Scope.jsp"); 
	
	//forward : 웹 서버 내부에서만 이동하는 기술
	// -> request, response 정보를 가지고 이동
	// -> url에 변화가 없다.
	/* RequestDispatcher dispatcher = request.getRequestDispatcher("ex02Scope.jsp");
	
	
	dispatcher.forward(request, response); //정보를 가지고 넘어간다. */
	
	%>
	
	
	
</body>
</html>