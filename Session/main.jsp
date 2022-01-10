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
	//세션 생성
	session.setAttribute("id", "asdf");
	session.setAttribute("pw", 1234);
	%>

	<%
	String nick = (String) session.getAttribute("nick");
	if (nick == null) {
	%>
	<fieldset>
		<legend align="center">로그인</legend>
		<form action="LoginService" method="post">
			<div align="center">
				<input type="text" name="ID" placeholder="ID를 입력하세요"><br>
				<input type="password" name="PW" placeholder="PW를 입력하세요"><br>
				<input type="submit" value="로그인">
			</div>
		</form>
	</fieldset>
	<%
	} else if (nick != null) {
	out.print(nick);
	%>
	<h1>로그인중입니다.</h1>
	<a href="logout.jsp">로그아웃하기</a>


	<%
	}
	%>


	


</body>
</html>