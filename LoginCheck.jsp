<%@page import="java.net.URLEncoder"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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
	//MVC패턴1 = JSP사용
	//MVC패턴2 = JSP 와 Servlet사용(jsp가 'v'이고 서블릿이 'c' , dao가 'm')
	//지금 하고있는건 mvc패턴1 !
	//login.html 에서 입력된 id,pw값을 변수에 저장
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	//jdbc 연결을 통해서 로그인 기능 구현
	//jdbc 연결 과정 ->> 교재 8장 아니면 9장!!
	//1. OracleDriber 연결
	//2. DB연결(Connection 객체 사용)
	//3. 쿼리문 작성 & 실행
	//4. DB연결 종료
	
	Class.forName("oracle.jdbc.driver.OracleDriver"); //사용할 오라클 드라이버 클래스를 불러오기
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String password = "hr";
	Connection conn = DriverManager.getConnection(url, user, password); 
	//sql을 가지고 있는 커넥션을 임포트! -> 커넥션은 인터페이스인걸로 임포트!
	//외부 라이브러리는 Web-inf 파일의 lib파일에 넣어야 한다!!!!!!!
	//드라이버를 lib에 꼭 담아야 한다!
/* 	if(conn == null) out.print("db연결실패");
	else out.print("db연결성공"); */
	
	String sql = "select * from s_member where m_id=? and m_pw=?"; //넘겨받은 id와 pw을 통해 확인
	
	PreparedStatement psmt = conn.prepareStatement(sql); 
	//prepareStatement는 sql문이 지나가는 통로역활!(db와 프로그램을 연결하는 통로이다.)
	
	psmt.setString(1,id);
	psmt.setString(2,pw);
	
	ResultSet rs = psmt.executeQuery();
	
	if(rs.next()){ //next()는 한번만 부르면 한번만 반환한다(5개를 반환하려면 5번 호출해야한다.)
		String nick = rs.getString("m_nick"); //or  rs.getString(3); 컬럼의 번호
		response.sendRedirect("loginTrue.jsp?nick=" +URLEncoder.encode(nick,"UTF-8")); 
		//URL주소로 정보를 넘기는 방법 -> GET방식!(GET방식은 SERVER.XML에서 인코딩 해주어야 한다.)
		//URLEncoder.encode(문자열데이터,"인코딩방식") -> URL주소창에 한글데이터를 전달 할 때 사용!
		//URLEncoder.encode(nick,"UTF-8") 을 해놓으면 SERVER.XML을 안해도 되지만 해두는게 좋다!
	}else {
		response.sendRedirect("loginFalse.jsp");
	}
	
	rs.close();
	psmt.close();
	conn.close();
	
	
	
	
	
	
	
	
	
	
	
	/* if(id.equals("smhrd") && pw.equals("1234")){
		response.sendRedirect("loginTrue.jsp?id=" +id); //쿼리스트링을 사용하여 id값을 넘겨준다.(url로 볼수있게 넘겨준다.)
	}else{
		response.sendRedirect("loginFalse.jsp");
	}
	 */
%>
</body>
</html>