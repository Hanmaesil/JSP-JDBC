<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL문법 다루기!</h1>
	
	\${true} : ${true} <!-- 문법 앞에 역슬래쉬(\)를 넣으면 있는 그대로 문자열로 출력된다.  -->
	<br>
	\${30} : ${30}
	<br>
	\${3.14} : ${3.14}
	<br>
	\${"Hello"} : ${"Hello"}
	<br>
	\${'World'} : ${'World'}
	<br>
	\${10+5} : ${10+5}
	<br>
	\${"5" +1} : ${"5" + 1} <!-- 자동으로 변환되어 계산 된다  -->
	<br>
	<%-- \${6 div 2 } : ${6 div 2} --%>
	<br>
	\${"JSP" == "JSP"} : ${"JSP" == "JSP" }
	<br>
	<!-- empty 값(변수)  >> 비어있다면 ture가 반환된다.-->
	\${empty num} : ${empty num}
	<br>
	\${empty "" } : ${empty "" }
	
	
	
	
	
	
	
</body>
</html>