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
	
	<h1>세션 값 조회</h1>
	<!-- 세션정보를 바로 출력할 때  -->
<%-- 	세션에 저장된 값 : <%= session.getAttribute("msg") %> --%>
	<!-- 세션 정보를 활용 할 때  -->
	<!-- 다운캐스팅으로 변수에 저장! -->
	<!-- 다운캐스팅 하는 이유 : 세션에 저장 될 떄 object타입으로 저장되기 때문이다.  -->
	<%
	 String msg = (String)session.getAttribute("msg");
	out.println("세션에 저장된 값 : " + msg + "<br>");
	
	//기본데이터 타입으로 저장된 데이터는 변수에 저장할 때 객체타입으로 저장할 것!.
	//->> 기본데이터 타입은 null값을 처리할 수 없기 때문이다!!!!!
	//정수나 실수타입을 받을 때 integer객체로 받는게 좋다.
	Integer num = (Integer)session.getAttribute("num");
	out.print("세션에 저장된 값 :" + num + "<br>");
	
	ArrayList<String> list = (ArrayList)session.getAttribute("list");
	//어레이리스트에 memberdto를 넣으면 회원정보를 볼 수 있다!
	for(int i = 0; i < list.size(); i++){
		out.print(list.get(i) + "<br>");
	}
	
	
	
	%>
	
</body>
</html>