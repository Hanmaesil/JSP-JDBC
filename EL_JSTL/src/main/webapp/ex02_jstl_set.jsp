<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var = "request" value="getReq" scope="request"/>
	<c:set var = "session" value = "getSession" scope = "session"/>
	<c:set var = "application" value = "getApplication" scope="application"/>
	<h1><strong>JSTL다루기</strong></h1>
	<br><br>
	${request}<br>
	${session}<br>
	${application}<br>
	${requestScope.request} ${sessionScope.session} ${applicationScope.application}<br><br>
	
	
	<!-- remove var = "삭제할 변수명" scope = "저장된영역" --><!-- remove를 사용할 때 같은 영역에 같은 이름이 있을 수 있기 때문에 영역을 적어준다.  -->
	<!-- scope를 살정하면 특정 서버영역에 데이터를 삭제 -->
	<c:remove var="request" scope="request"/>
	request영역에 저장된 데이터 : 
	${request}
	${requestScope.request}
	
</body>
</html>