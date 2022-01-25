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
	<table border="1">
		<c:forEach var = "j" begin="2" end = "9">
			<tr>
				<c:forEach var="i" begin="1" end="9">
					<td>${j} * ${i} = ${j*i}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>