<%@page import="java.util.ArrayList"%>
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
	//세션 : 사용자의 정보를 서버에 저장하는 기술
	//- > 노출되면 안되는 중요한 정보들을 저장할 때 세션을 사용한다.
	//setAttribute(이름, 값)
	//값은 object 타입으로 저장하게 되어 있지만 다른 타입을 넣어도 업캐스팅이 일어나기 때문에 반드시 object타입을 넣을 필요는 없다.
	session.setAttribute("msg", "세션에 데이터 저장");
	session.setAttribute("num", 150);
	
	ArrayList<String> list = new ArrayList<String>();
	list.add("오늘도");
	list.add("날씨가");
	list.add("춥드아!");
	
	session.setAttribute("list", list);
	
	
	//사용자의 정보를 유지시켜주는 메소드(세션정보의 유효기간을 설정하는 메소드)
	//setMaxInactiveInterval(초단위)
	session.setMaxInactiveInterval(60);
	
	%>
	
	
</body>
</html>